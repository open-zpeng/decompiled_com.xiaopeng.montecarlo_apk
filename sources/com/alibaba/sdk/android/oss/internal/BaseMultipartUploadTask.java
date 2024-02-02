package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    protected final int CPU_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected InternalRequestOperation mApiOperation;
    protected boolean mCheckCRC64;
    protected OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected Object mLock;
    protected int[] mPartAttr;
    protected List<PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    protected OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected int mRunPartTaskCount;
    protected Exception mUploadException;
    protected File mUploadFile;
    protected String mUploadFilePath;
    protected String mUploadId;
    protected long mUploadedLength;

    protected abstract void abortThisUpload();

    protected abstract Result doMultipartUpload() throws IOException, ServiceException, ClientException, InterruptedException;

    protected abstract void initMultipartUploadId() throws IOException, ClientException, ServiceException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void preUploadPart(int i, int i2, int i3) throws Exception {
    }

    protected abstract void processException(Exception exc);

    protected void uploadPartFinish(PartETag partETag) throws Exception {
    }

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int i = this.CPU_SIZE;
        this.MAX_CORE_POOL_SIZE = i >= 5 ? 5 : i;
        this.MAX_IMUM_POOL_SIZE = this.CPU_SIZE;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = 5000;
        this.mPoolExecutor = new ThreadPoolExecutor(this.MAX_CORE_POOL_SIZE, this.MAX_IMUM_POOL_SIZE, 3000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0L;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == OSSRequest.CRC64Config.YES;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
        }
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        ClientException clientException;
        try {
            checkInitData();
            initMultipartUploadId();
            Result doMultipartUpload = doMultipartUpload();
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onSuccess(this.mRequest, doMultipartUpload);
            }
            return doMultipartUpload;
        } catch (ServiceException e) {
            OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(this.mRequest, null, e);
            }
            throw e;
        } catch (Exception e2) {
            if (e2 instanceof ClientException) {
                clientException = (ClientException) e2;
            } else {
                clientException = new ClientException(e2.toString(), e2);
            }
            OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }

    protected void checkInitData() throws ClientException {
        this.mUploadFilePath = this.mRequest.getUploadFilePath();
        this.mUploadedLength = 0L;
        this.mUploadFile = new File(this.mUploadFilePath);
        this.mFileLength = this.mUploadFile.length();
        if (this.mFileLength == 0) {
            throw new ClientException("file length must not be 0");
        }
        checkPartSize(this.mPartAttr);
        long partSize = this.mRequest.getPartSize();
        int i = this.mPartAttr[1];
        OSSLog.logDebug("[checkInitData] - partNumber : " + i);
        OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
        if (i > 1 && partSize < OSSConstants.MIN_PART_SIZE_LIMIT) {
            throw new ClientException("Part size must be greater than or equal to 100KB!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadPart(int i, int i2, int i3) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                }
            } catch (Exception e) {
                e = e;
            }
            if (this.mContext.getCancellationHandler().isCancelled()) {
                this.mPoolExecutor.getQueue().clear();
                return;
            }
            synchronized (this.mLock) {
                this.mRunPartTaskCount++;
            }
            preUploadPart(i, i2, i3);
            randomAccessFile = new RandomAccessFile(this.mUploadFile, "r");
            try {
                UploadPartRequest uploadPartRequest = new UploadPartRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, i + 1);
                byte[] bArr = new byte[i2];
                randomAccessFile.seek(i * this.mRequest.getPartSize());
                randomAccessFile.readFully(bArr, 0, i2);
                uploadPartRequest.setPartContent(bArr);
                uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(bArr));
                uploadPartRequest.setCRC64(this.mRequest.getCRC64());
                UploadPartResult syncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
                synchronized (this.mLock) {
                    PartETag partETag = new PartETag(uploadPartRequest.getPartNumber(), syncUploadPart.getETag());
                    long j = i2;
                    partETag.setPartSize(j);
                    if (this.mCheckCRC64) {
                        partETag.setCRC64(syncUploadPart.getClientCRC().longValue());
                    }
                    this.mPartETags.add(partETag);
                    this.mUploadedLength += j;
                    uploadPartFinish(partETag);
                    if (this.mContext.getCancellationHandler().isCancelled()) {
                        if (this.mPartETags.size() == this.mRunPartTaskCount - this.mPartExceptionCount) {
                            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
                            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
                        }
                    } else {
                        if (this.mPartETags.size() == i3 - this.mPartExceptionCount) {
                            notifyMultipartThread();
                        }
                        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                    }
                }
                randomAccessFile.close();
            } catch (Exception e2) {
                e = e2;
                randomAccessFile2 = randomAccessFile;
                processException(e);
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e3) {
                        OSSLog.logThrowable2Local(e3);
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            OSSLog.logThrowable2Local(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CompleteMultipartUploadResult completeMultipartUploadResult() throws ClientException, ServiceException {
        CompleteMultipartUploadResult completeMultipartUploadResult;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.2
                @Override // java.util.Comparator
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            completeMultipartUploadRequest.setMetadata(this.mRequest.getMetadata());
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResult = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResult = null;
        }
        this.mUploadedLength = 0L;
        return completeMultipartUploadResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mUploadException != null) {
            releasePool();
            Exception exc = this.mUploadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            }
            if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            }
            if (exc instanceof ClientException) {
                throw ((ClientException) exc);
            }
            throw new ClientException(exc.getMessage(), this.mUploadException);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkWaitCondition(int i) {
        return this.mPartETags.size() != i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    protected void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j = this.mFileLength;
        int i = (int) (j / partSize);
        if (j % partSize != 0) {
            i++;
        }
        if (i == 1) {
            partSize = this.mFileLength;
        } else if (i > 5000) {
            partSize = this.mFileLength / 5000;
            i = 5000;
        }
        int i2 = (int) partSize;
        iArr[0] = i2;
        iArr[1] = i;
        this.mRequest.setPartSize(i2);
        OSSLog.logDebug("[checkPartSize] - partNumber : " + i);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onProgressCallback(Request request, long j, long j2) {
        OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j, j2);
        }
    }
}

package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex;
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp;

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.mAlreadyUploadIndex = new ArrayList();
        this.mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0183 A[Catch: ClientException -> 0x01ee, ServiceException -> 0x01f0, TryCatch #6 {ClientException -> 0x01ee, ServiceException -> 0x01f0, blocks: (B:48:0x016a, B:49:0x017d, B:51:0x0183, B:53:0x019f, B:55:0x01a5, B:57:0x01b3, B:58:0x01c8, B:60:0x01e5), top: B:93:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x023e  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.initMultipartUploadId():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j = this.mUploadedLength;
        checkCancel();
        int i = this.mPartAttr[0];
        int i2 = this.mPartAttr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            if (this.mUploadedLength > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (this.mFirstPartSize != i) {
                throw new ClientException("The part size setting is inconsistent with before");
            }
            long j2 = this.mUploadedLength;
            if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                j2 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
            }
            long j3 = j2;
            if (this.mProgressCallback != null) {
                this.mProgressCallback.onProgress(this.mRequest, j3, this.mFileLength);
            }
            this.mSp.removeKey(this.mUploadId);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                OSSLog.logDebug("upload part readByte : " + i);
                j += (long) i;
                uploadPart(i3, i, i2);
                if (this.mUploadException != null) {
                    break;
                }
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = completeMultipartUploadResult != null ? new ResumableUploadResult(completeMultipartUploadResult) : null;
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        return resumableUploadResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01cf A[Catch: IOException -> 0x01c6, TRY_LEAVE, TryCatch #10 {IOException -> 0x01c6, blocks: (B:95:0x01c2, B:99:0x01ca, B:101:0x01cf), top: B:106:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144 A[Catch: IOException -> 0x0148, TRY_ENTER, TryCatch #8 {IOException -> 0x0148, blocks: (B:37:0x00f5, B:39:0x00fa, B:41:0x00ff, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c A[Catch: IOException -> 0x0148, TryCatch #8 {IOException -> 0x0148, blocks: (B:37:0x00f5, B:39:0x00fa, B:41:0x00ff, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0151 A[Catch: IOException -> 0x0148, TRY_LEAVE, TryCatch #8 {IOException -> 0x0148, blocks: (B:37:0x00f5, B:39:0x00fa, B:41:0x00ff, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0165 A[Catch: all -> 0x01bc, TryCatch #16 {all -> 0x01bc, blocks: (B:65:0x013f, B:78:0x015d, B:80:0x0165, B:81:0x0169, B:83:0x0183, B:84:0x01a1), top: B:109:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0169 A[Catch: all -> 0x01bc, TryCatch #16 {all -> 0x01bc, blocks: (B:65:0x013f, B:78:0x015d, B:80:0x0165, B:81:0x0169, B:83:0x0183, B:84:0x01a1), top: B:109:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ae A[Catch: IOException -> 0x0148, TRY_ENTER, TryCatch #8 {IOException -> 0x0148, blocks: (B:37:0x00f5, B:39:0x00fa, B:41:0x00ff, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b3 A[Catch: IOException -> 0x0148, TryCatch #8 {IOException -> 0x0148, blocks: (B:37:0x00f5, B:39:0x00fa, B:41:0x00ff, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b8 A[Catch: IOException -> 0x0148, TRY_LEAVE, TryCatch #8 {IOException -> 0x0148, blocks: (B:37:0x00f5, B:39:0x00fa, B:41:0x00ff, B:67:0x0144, B:71:0x014c, B:73:0x0151, B:86:0x01ae, B:88:0x01b3, B:90:0x01b8), top: B:105:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ca A[Catch: IOException -> 0x01c6, TryCatch #10 {IOException -> 0x01c6, blocks: (B:95:0x01c2, B:99:0x01ca, B:101:0x01cf), top: B:106:0x01c2 }] */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void uploadPart(int r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.uploadPart(int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void checkException() throws IOException, ServiceException, ClientException {
        ObjectOutputStream objectOutputStream;
        if (this.mContext.getCancellationHandler().isCancelled()) {
            if (((ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
                abortThisUpload();
                File file = this.mRecordFile;
                if (file != null) {
                    file.delete();
                }
            } else if (this.mPartETags != null && this.mPartETags.size() > 0 && this.mCheckCRC64 && ((ResumableUploadRequest) this.mRequest).getRecordDirectory() != null) {
                HashMap hashMap = new HashMap();
                for (PartETag partETag : this.mPartETags) {
                    hashMap.put(Integer.valueOf(partETag.getPartNumber()), Long.valueOf(partETag.getCRC64()));
                }
                ObjectOutputStream objectOutputStream2 = null;
                try {
                    try {
                        this.mCRC64RecordFile = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                        if (!this.mCRC64RecordFile.exists()) {
                            this.mCRC64RecordFile.createNewFile();
                        }
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.mCRC64RecordFile));
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    objectOutputStream.writeObject(hashMap);
                    objectOutputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    objectOutputStream2 = objectOutputStream;
                    OSSLog.logThrowable2Local(e);
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                    super.checkException();
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                    throw th;
                }
            }
        }
        super.checkException();
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void processException(Exception exc) {
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mIsCancel) {
            return;
        }
        this.mIsCancel = true;
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void uploadPartFinish(PartETag partETag) throws Exception {
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mSp.contains(this.mUploadId)) {
            return;
        }
        this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
    }
}

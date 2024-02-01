package com.alibaba.sdk.android.oss.internal;

import android.util.Log;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.exception.InconsistentException;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.Range;
import com.alibaba.sdk.android.oss.model.ResumableDownloadRequest;
import com.alibaba.sdk.android.oss.model.ResumableDownloadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.autonavi.gbl.guide.model.RangeType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class ResumableDownloadTask<Requst extends ResumableDownloadRequest, Result extends ResumableDownloadResult> implements Callable<Result> {
    protected final int CPU_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected String checkpointPath;
    protected long completedPartSize;
    protected long downloadPartSize;
    private CheckPoint mCheckPoint;
    private OSSCompletedCallback mCompletedCallback;
    private ExecutionContext mContext;
    protected Exception mDownloadException;
    protected Object mLock;
    private InternalRequestOperation mOperation;
    protected long mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    private OSSProgressCallback mProgressCallback;
    private ResumableDownloadRequest mRequest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumableDownloadTask(InternalRequestOperation internalRequestOperation, ResumableDownloadRequest resumableDownloadRequest, OSSCompletedCallback oSSCompletedCallback, ExecutionContext executionContext) {
        int i = this.CPU_SIZE;
        this.MAX_CORE_POOL_SIZE = i >= 5 ? 5 : i;
        this.MAX_IMUM_POOL_SIZE = this.CPU_SIZE;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = 5000;
        this.mPoolExecutor = new ThreadPoolExecutor(this.MAX_CORE_POOL_SIZE, this.MAX_IMUM_POOL_SIZE, 3000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mLock = new Object();
        this.mRequest = resumableDownloadRequest;
        this.mOperation = internalRequestOperation;
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mProgressCallback = resumableDownloadRequest.getProgressListener();
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        ClientException clientException;
        try {
            checkInitData();
            Result result = (Result) doMultipartDownload();
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onSuccess(this.mRequest, result);
            }
            return result;
        } catch (ServiceException e) {
            OSSCompletedCallback oSSCompletedCallback = this.mCompletedCallback;
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
            OSSCompletedCallback oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }

    protected void checkInitData() throws ClientException, ServiceException, IOException {
        if (this.mRequest.getRange() != null && !this.mRequest.getRange().checkIsValid()) {
            throw new ClientException("Range is invalid");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mRequest.getBucketName());
        sb.append(this.mRequest.getObjectKey());
        sb.append(String.valueOf(this.mRequest.getPartSize()));
        sb.append(this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES ? "-crc64" : "");
        String calculateMd5Str = BinaryUtil.calculateMd5Str(sb.toString().getBytes());
        this.checkpointPath = this.mRequest.getCheckPointFilePath() + File.separator + calculateMd5Str;
        this.mCheckPoint = new CheckPoint();
        if (this.mRequest.getEnableCheckPoint().booleanValue()) {
            try {
                this.mCheckPoint.load(this.checkpointPath);
            } catch (Exception unused) {
                removeFile(this.checkpointPath);
                removeFile(this.mRequest.getTempFilePath());
            }
            if (this.mCheckPoint.isValid(this.mOperation)) {
                return;
            }
            removeFile(this.checkpointPath);
            removeFile(this.mRequest.getTempFilePath());
            initCheckPoint();
            return;
        }
        initCheckPoint();
    }

    protected boolean removeFile(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    private void initCheckPoint() throws ClientException, ServiceException, IOException {
        FileStat fileStat = FileStat.getFileStat(this.mOperation, this.mRequest.getBucketName(), this.mRequest.getObjectKey());
        Range correctRange = correctRange(this.mRequest.getRange(), fileStat.fileLength);
        createFile(this.mRequest.getTempFilePath(), correctRange.getEnd() - correctRange.getBegin());
        this.mCheckPoint.bucketName = this.mRequest.getBucketName();
        this.mCheckPoint.objectKey = this.mRequest.getObjectKey();
        CheckPoint checkPoint = this.mCheckPoint;
        checkPoint.fileStat = fileStat;
        checkPoint.parts = splitFile(correctRange, checkPoint.fileStat.fileLength, this.mRequest.getPartSize());
    }

    protected ResumableDownloadResult doMultipartDownload() throws ClientException, ServiceException, IOException, InterruptedException {
        checkCancel();
        ResumableDownloadResult resumableDownloadResult = new ResumableDownloadResult();
        final DownloadFileResult downloadFileResult = new DownloadFileResult();
        downloadFileResult.partResults = new ArrayList<>();
        Iterator<DownloadPart> it = this.mCheckPoint.parts.iterator();
        while (it.hasNext()) {
            final DownloadPart next = it.next();
            checkException();
            if (this.mPoolExecutor != null && !next.isCompleted) {
                this.mPoolExecutor.execute(new Runnable() { // from class: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ResumableDownloadTask.this.downloadPart(downloadFileResult, next);
                        Log.i("partResults", "start: " + next.start + ", end: " + next.end);
                    }
                });
            } else {
                DownloadPartResult downloadPartResult = new DownloadPartResult();
                downloadPartResult.partNumber = next.partNumber;
                downloadPartResult.requestId = this.mCheckPoint.fileStat.requestId;
                downloadPartResult.length = next.length;
                if (this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES) {
                    downloadPartResult.clientCRC = Long.valueOf(next.crc);
                }
                downloadFileResult.partResults.add(downloadPartResult);
                this.downloadPartSize++;
                this.completedPartSize++;
            }
        }
        if (checkWaitCondition(this.mCheckPoint.parts.size())) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        Collections.sort(downloadFileResult.partResults, new Comparator<DownloadPartResult>() { // from class: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.3
            @Override // java.util.Comparator
            public int compare(DownloadPartResult downloadPartResult2, DownloadPartResult downloadPartResult3) {
                return downloadPartResult2.partNumber - downloadPartResult3.partNumber;
            }
        });
        if (this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES && this.mRequest.getRange() == null) {
            Long calcObjectCRCFromParts = calcObjectCRCFromParts(downloadFileResult.partResults);
            resumableDownloadResult.setClientCRC(calcObjectCRCFromParts);
            try {
                OSSUtils.checkChecksum(calcObjectCRCFromParts, this.mCheckPoint.fileStat.serverCRC, downloadFileResult.partResults.get(0).requestId);
            } catch (InconsistentException e) {
                removeFile(this.checkpointPath);
                removeFile(this.mRequest.getTempFilePath());
                throw e;
            }
        }
        removeFile(this.checkpointPath);
        moveFile(new File(this.mRequest.getTempFilePath()), new File(this.mRequest.getDownloadToFilePath()));
        resumableDownloadResult.setServerCRC(this.mCheckPoint.fileStat.serverCRC);
        resumableDownloadResult.setMetadata(downloadFileResult.metadata);
        resumableDownloadResult.setRequestId(downloadFileResult.partResults.get(0).requestId);
        resumableDownloadResult.setStatusCode(200);
        return resumableDownloadResult;
    }

    private static Long calcObjectCRCFromParts(List<DownloadPartResult> list) {
        long j = 0;
        for (DownloadPartResult downloadPartResult : list) {
            if (downloadPartResult.clientCRC == null || downloadPartResult.length <= 0) {
                return null;
            }
            j = CRC64.combine(j, downloadPartResult.clientCRC.longValue(), downloadPartResult.length);
        }
        return new Long(j);
    }

    private ArrayList<DownloadPart> splitFile(Range range, long j, long j2) {
        int i = 0;
        if (j <= 0) {
            DownloadPart downloadPart = new DownloadPart();
            downloadPart.start = 0L;
            downloadPart.end = -1L;
            downloadPart.length = 0L;
            downloadPart.partNumber = 0;
            ArrayList<DownloadPart> arrayList = new ArrayList<>();
            arrayList.add(downloadPart);
            return arrayList;
        }
        long begin = range.getBegin();
        long end = range.getEnd() - range.getBegin();
        long j3 = end / j2;
        if (end % j2 > 0) {
            j3++;
        }
        ArrayList<DownloadPart> arrayList2 = new ArrayList<>();
        while (true) {
            long j4 = i;
            if (j4 >= j3) {
                return arrayList2;
            }
            DownloadPart downloadPart2 = new DownloadPart();
            long j5 = j4 * j2;
            downloadPart2.start = begin + j5;
            int i2 = i + 1;
            downloadPart2.end = ((i2 * j2) + begin) - 1;
            downloadPart2.length = (downloadPart2.end - downloadPart2.start) + 1;
            long j6 = begin + end;
            if (downloadPart2.end >= j6) {
                downloadPart2.end = -1L;
                downloadPart2.length = j6 - downloadPart2.start;
            }
            downloadPart2.partNumber = i;
            downloadPart2.fileStart = j5;
            arrayList2.add(downloadPart2);
            i = i2;
        }
    }

    private Range correctRange(Range range, long j) {
        if (range != null) {
            r0 = range.getBegin() != -1 ? range.getBegin() : 0L;
            j = range.getEnd() == -1 ? j - r0 : range.getEnd() - range.getBegin();
        }
        return new Range(r0, j + r0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018c A[Catch: IOException -> 0x0188, TRY_LEAVE, TryCatch #0 {IOException -> 0x0188, blocks: (B:64:0x0184, B:68:0x018c), top: B:72:0x0184 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void downloadPart(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask<Requst, Result>.DownloadFileResult r13, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart r14) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.downloadPart(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadFileResult, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadPart):void");
    }

    private void createFile(String str, long j) throws IOException {
        File file = new File(str);
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile2.setLength(j);
                randomAccessFile2.close();
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void moveFile(java.io.File r5, java.io.File r6) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r5.renameTo(r6)
            if (r0 != 0) goto L63
            java.lang.String r0 = "moveFile"
            java.lang.String r1 = "rename"
            android.util.Log.i(r0, r1)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4f java.io.FileNotFoundException -> L53
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L4f java.io.FileNotFoundException -> L53
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4b
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4b
            r4.copyFile(r1, r2)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            boolean r6 = r5.delete()     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            if (r6 == 0) goto L28
            r1.close()
            r2.close()
            goto L63
        L28:
            java.io.IOException r6 = new java.io.IOException     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            r0.<init>()     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            java.lang.String r3 = "Failed to delete original file '"
            r0.append(r3)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            r0.append(r5)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            java.lang.String r5 = "'"
            r0.append(r5)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            throw r6     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
        L44:
            r5 = move-exception
            goto L58
        L46:
            r5 = move-exception
            goto L4d
        L48:
            r5 = move-exception
            r2 = r0
            goto L58
        L4b:
            r5 = move-exception
            r2 = r0
        L4d:
            r0 = r1
            goto L55
        L4f:
            r5 = move-exception
            r1 = r0
            r2 = r1
            goto L58
        L53:
            r5 = move-exception
            r2 = r0
        L55:
            throw r5     // Catch: java.lang.Throwable -> L56
        L56:
            r5 = move-exception
            r1 = r0
        L58:
            if (r1 == 0) goto L5d
            r1.close()
        L5d:
            if (r2 == 0) goto L62
            r2.close()
        L62:
            throw r5
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.moveFile(java.io.File, java.io.File):void");
    }

    private void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    protected void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0L;
    }

    protected void processException(Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            if (this.mDownloadException == null) {
                this.mDownloadException = exc;
                this.mLock.notify();
            }
        }
    }

    protected void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    protected void checkException() throws IOException, ServiceException, ClientException {
        if (this.mDownloadException != null) {
            releasePool();
            Exception exc = this.mDownloadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            }
            if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            }
            if (exc instanceof ClientException) {
                throw ((ClientException) exc);
            }
            throw new ClientException(exc.getMessage(), this.mDownloadException);
        }
    }

    protected boolean checkWaitCondition(int i) {
        return this.completedPartSize != ((long) i);
    }

    protected void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("Resumable download cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DownloadPart implements Serializable {
        private static final long serialVersionUID = -3506020776131733942L;
        public long crc;
        public long end;
        public long fileStart;
        public boolean isCompleted;
        public long length;
        public int partNumber;
        public long start;

        DownloadPart() {
        }

        public int hashCode() {
            int i = (this.partNumber + 31) * 31;
            int i2 = this.isCompleted ? RangeType.RANGETYPE_CAMERA_SPEED_PROMPT : 1237;
            long j = this.end;
            long j2 = this.start;
            long j3 = this.crc;
            return ((((((i + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CheckPoint implements Serializable {
        private static final long serialVersionUID = -8470273912385636504L;
        public String bucketName;
        public String downloadFile;
        public long downloadLength;
        public FileStat fileStat;
        public int md5;
        public String objectKey;
        public ArrayList<DownloadPart> parts;

        CheckPoint() {
        }

        public synchronized void load(String str) throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;
            ObjectInputStream objectInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        objectInputStream = new ObjectInputStream(fileInputStream);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
                try {
                    assign((CheckPoint) objectInputStream.readObject());
                    objectInputStream.close();
                    fileInputStream.close();
                } catch (Throwable th3) {
                    objectInputStream2 = objectInputStream;
                    th = th3;
                    if (objectInputStream2 != null) {
                        objectInputStream2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }

        public synchronized void dump(String str) throws IOException {
            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;
            this.md5 = hashCode();
            ObjectOutputStream objectOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(this);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Throwable th3) {
                objectOutputStream2 = objectOutputStream;
                th = th3;
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }

        public synchronized void update(int i, boolean z) throws IOException {
            this.parts.get(i).isCompleted = z;
            this.downloadLength += this.parts.get(i).length;
        }

        public synchronized boolean isValid(InternalRequestOperation internalRequestOperation) throws ClientException, ServiceException {
            if (this.md5 != hashCode()) {
                return false;
            }
            FileStat fileStat = FileStat.getFileStat(internalRequestOperation, this.bucketName, this.objectKey);
            if (this.fileStat.lastModified == null) {
                if (this.fileStat.fileLength != fileStat.fileLength || !this.fileStat.etag.equals(fileStat.etag)) {
                    return false;
                }
            } else if (this.fileStat.fileLength != fileStat.fileLength || !this.fileStat.lastModified.equals(fileStat.lastModified) || !this.fileStat.etag.equals(fileStat.etag)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.bucketName;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.downloadFile;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.objectKey;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            FileStat fileStat = this.fileStat;
            int hashCode4 = (hashCode3 + (fileStat == null ? 0 : fileStat.hashCode())) * 31;
            ArrayList<DownloadPart> arrayList = this.parts;
            int hashCode5 = arrayList != null ? arrayList.hashCode() : 0;
            long j = this.downloadLength;
            return ((hashCode4 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)));
        }

        private void assign(CheckPoint checkPoint) {
            this.md5 = checkPoint.md5;
            this.downloadFile = checkPoint.downloadFile;
            this.bucketName = checkPoint.bucketName;
            this.objectKey = checkPoint.objectKey;
            this.fileStat = checkPoint.fileStat;
            this.parts = checkPoint.parts;
            this.downloadLength = checkPoint.downloadLength;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FileStat implements Serializable {
        private static final long serialVersionUID = 3896323364904643963L;
        public String etag;
        public long fileLength;
        public Date lastModified;
        public String md5;
        public String requestId;
        public Long serverCRC;

        FileStat() {
        }

        public static FileStat getFileStat(InternalRequestOperation internalRequestOperation, String str, String str2) throws ClientException, ServiceException {
            HeadObjectResult result = internalRequestOperation.headObject(new HeadObjectRequest(str, str2), null).getResult();
            FileStat fileStat = new FileStat();
            fileStat.fileLength = result.getMetadata().getContentLength();
            fileStat.etag = result.getMetadata().getETag();
            fileStat.lastModified = result.getMetadata().getLastModified();
            fileStat.serverCRC = result.getServerCRC();
            fileStat.requestId = result.getRequestId();
            return fileStat;
        }

        public int hashCode() {
            String str = this.etag;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Date date = this.lastModified;
            int hashCode2 = date != null ? date.hashCode() : 0;
            long j = this.fileLength;
            return ((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DownloadPartResult {
        public Long clientCRC;
        public long length;
        public int partNumber;
        public String requestId;

        DownloadPartResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DownloadFileResult extends OSSResult {
        public ObjectMetadata metadata;
        public ArrayList<DownloadPartResult> partResults;

        DownloadFileResult() {
        }
    }
}

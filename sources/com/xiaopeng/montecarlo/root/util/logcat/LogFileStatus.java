package com.xiaopeng.montecarlo.root.util.logcat;
/* loaded from: classes3.dex */
public class LogFileStatus {
    static final int FILE_NOT_EXISTS = -1;
    static final int UNUSED = 0;
    static final int WAITING_TO_DEL = 1;
    static final int WAITING_TO_ZIP = 2;
    static final int ZIPPED = 4;

    /* loaded from: classes3.dex */
    public enum CopyLogFileErrCode {
        LOG_FILE_NO_ERROR,
        LOG_FILE_COPY_FAILED,
        LOG_FILE_ZIP_FAILED,
        LOG_FILE_NO_USB,
        LOG_FILE_NO_ENOUGH_SPACE
    }

    /* loaded from: classes3.dex */
    public enum CopyLogFileStatus {
        LOG_FILE_COPY_PREPARE,
        LOG_FILE_COPY_START,
        LOG_FILE_COPY_PROCESS,
        LOG_FILE_ZIP_PROCESS,
        LOG_FILE_COPY_DONE
    }
}

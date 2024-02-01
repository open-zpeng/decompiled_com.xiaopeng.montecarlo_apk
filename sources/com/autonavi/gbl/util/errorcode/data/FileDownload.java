package com.autonavi.gbl.util.errorcode.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class FileDownload {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ErrorCodeFileDownloadCancel = 1107427333;
    public static final int ErrorCodeFileDownloadFailed = 1107427332;
    public static final int ErrorCodeFileDownloadIdle = 1107427329;
    public static final int ErrorCodeFileDownloadInProgess = 1107427330;
    public static final int ErrorCodeFileDownloadInnerError = 1107427341;
    public static final int ErrorCodeFileDownloadMd5CheckFailed = 1107427334;
    public static final int ErrorCodeFileDownloadRequestOK = 1107427328;
    public static final int ErrorCodeFileDownloadSaveDirCanNotWrite = 1107427340;
    public static final int ErrorCodeFileDownloadSaveDirIlegal = 1107427339;
    public static final int ErrorCodeFileDownloadSaveDirNotExist = 1107427338;
    public static final int ErrorCodeFileDownloadStrFileEmpty = 1107427336;
    public static final int ErrorCodeFileDownloadStrSaveDirEmpty = 1107427337;
    public static final int ErrorCodeFileDownloadSuccess = 1107427331;
    public static final int ErrorCodeFileDownloadUrlEmpty = 1107427335;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface FileDownload1 {
    }
}

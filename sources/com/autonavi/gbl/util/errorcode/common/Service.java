package com.autonavi.gbl.util.errorcode.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class Service {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ErrorCodeBadParamNullPoint = 4;
    public static final int ErrorCodeConfigFileInvalid = 15;
    public static final int ErrorCodeConfigPathInvalid = 14;
    public static final int ErrorCodeDBNoReady = 6;
    public static final int ErrorCodeDoing = 1;
    public static final int ErrorCodeFailed = -1;
    public static final int ErrorCodeFileName = 7;
    public static final int ErrorCodeFileNoExist = 8;
    public static final int ErrorCodeFileUpdating = 9;
    public static final int ErrorCodeGuideInitIsReadyFalse = 13;
    public static final int ErrorCodeInvalidParam = 3;
    public static final int ErrorCodeInvalidUser = 16;
    public static final int ErrorCodeJsonFile = 18;
    public static final int ErrorCodeLoadAssetConfig = 19;
    public static final int ErrorCodeNotInit = 2;
    public static final int ErrorCodeOK = 0;
    public static final int ErrorCodeObjectNullPoint = 5;
    public static final int ErrorCodePathName = 10;
    public static final int ErrorCodePathNoExist = 11;
    public static final int ErrorCodeSetOfflineDataModeError = 12;
    public static final int ErrorCodeUnknown = 16777215;
    public static final int ErrorCodeVerify = 17;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface Service1 {
    }
}

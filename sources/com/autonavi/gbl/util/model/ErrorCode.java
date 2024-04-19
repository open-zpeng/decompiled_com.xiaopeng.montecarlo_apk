package com.autonavi.gbl.util.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ErrorCode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ErrorCodeAutoOverlayType = 600;
    public static final int ErrorCodeAutoOverlayTypeNotInit = 602;
    public static final int ErrorCodeAutoOverlayTypeNotSupport = 601;
    public static final int ErrorCodeBadParamNullPoint = 3;
    public static final int ErrorCodeConfigFileInvalid = 1001;
    public static final int ErrorCodeConfigPathInvalid = 1000;
    public static final int ErrorCodeDBNoReady = 901;
    public static final int ErrorCodeExistZip = 104;
    public static final int ErrorCodeFailed = -1;
    public static final int ErrorCodeFileName = 101;
    public static final int ErrorCodeFileNoExist = 105;
    public static final int ErrorCodeFileUpdating = 106;
    public static final int ErrorCodeGuideInitDataProviderIsNull = 501;
    public static final int ErrorCodeGuideInitIsReadyFalse = 500;
    public static final int ErrorCodeInvalidParam = 1;
    public static final int ErrorCodeJNIStart = 200000;
    public static final int ErrorCodeLoginSuccess = 800;
    public static final int ErrorCodeNetCancel = 300;
    public static final int ErrorCodeNetFailed = 301;
    public static final int ErrorCodeNetTimeout = 302;
    public static final int ErrorCodeNetUnreach = 303;
    public static final int ErrorCodeNotInit = 200;
    public static final int ErrorCodeNotLogin = 900;
    public static final int ErrorCodeOK = 0;
    public static final int ErrorCodeOpenfile = 102;
    public static final int ErrorCodeOutOfMemory = 2;
    public static final int ErrorCodePathName = 100;
    public static final int ErrorCodeReadfile = 103;
    public static final int ErrorCodeRouteEngineInitErr = 402;
    public static final int ErrorCodeRouteInitDataProviderIsNull = 401;
    public static final int ErrorCodeRouteInitIsReadyFalse = 400;
    public static final int ErrorCodeSetOfflineDataModeError = 201;
    public static final int ErrorCodeUnknown = 1000000000;
    public static final int ErrorCodeUsbIncompatibleData = 1003;
    public static final int ErrorCodeUsbNoData = 1002;
    public static final int ErrorCodeVoiceEngineTypeNoSupport = 1006;
    public static final int ErrorCodeVoiceFlytekStorePathInvalid = 1004;
    public static final int ErrorCodeVoiceMitStorePathInvalid = 1005;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ErrorCode1 {
    }
}

package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RouteErrorcode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RouteErrorCodeRespTypeNotDef = 204;
    public static final int RouteErrorCodeRouteReqNotExist = 203;
    public static final int RouteErrorCodeRouteReqOverMax = 205;
    public static final int RouteErrorUnknow = -1;
    public static final int RouteErrorcodeBufferError = 9;
    public static final int RouteErrorcodeCalcRouteTimeOut = 35;
    public static final int RouteErrorcodeCallCenterError = 5;
    public static final int RouteErrorcodeCanNotFoundPathIDInFirst = 302;
    public static final int RouteErrorcodeCityNoSupportMotorcycle = 202;
    public static final int RouteErrorcodeConsisOfflineReqWithoutCustomId = 1004;
    public static final int RouteErrorcodeConsisSyncRouteTimeOut = 1006;
    public static final int RouteErrorcodeCrossCityNoSupportMotorcycle = 201;
    public static final int RouteErrorcodeDataIsNull = 254;
    public static final int RouteErrorcodeDecoderUninited = 0;
    public static final int RouteErrorcodeDynamicRouteNoBetter = 31;
    public static final int RouteErrorcodeEncodeFailure = 7;
    public static final int RouteErrorcodeEndNoRoad = 11;
    public static final int RouteErrorcodeEndNoSupportElectricBike = 102;
    public static final int RouteErrorcodeEndPointError = 6;
    public static final int RouteErrorcodeHalfwayNoRoad = 12;
    public static final int RouteErrorcodeHaveHighLevelTaskWorking = 64;
    public static final int RouteErrorcodeIlleageProtocol = 4;
    public static final int RouteErrorcodeLackEndCityData = 24;
    public static final int RouteErrorcodeLackPreviewData = 8;
    public static final int RouteErrorcodeLackStartCityData = 18;
    public static final int RouteErrorcodeLackViaCityData = 25;
    public static final int RouteErrorcodeLackWayCityData = 20;
    public static final int RouteErrorcodeMainRouteEmptyOrRestoreFail = 30;
    public static final int RouteErrorcodeNetworkError = 2;
    public static final int RouteErrorcodeNetworkTimeout = 16;
    public static final int RouteErrorcodeNoBackupRoute = 29;
    public static final int RouteErrorcodeNoBetterAbnormalBackupRoute = 32;
    public static final int RouteErrorcodeNoBetterFastBackupRoute = 33;
    public static final int RouteErrorcodeNoNewwork = 17;
    public static final int RouteErrorcodeNoRouteEncode = 28;
    public static final int RouteErrorcodeNoSaferRoute = 34;
    public static final int RouteErrorcodeOfflineRouteFailure = 14;
    public static final int RouteErrorcodeOverMaxRequest = 1003;
    public static final int RouteErrorcodePBPathNumIsNotEqualToFirst = 303;
    public static final int RouteErrorcodeParallelRouteFail = 36;
    public static final int RouteErrorcodeRequestAlreadyExist = 1001;
    public static final int RouteErrorcodeRequestNotExist = 1000;
    public static final int RouteErrorcodeRequestSendErr = 1002;
    public static final int RouteErrorcodeRequestStateODDError = 304;
    public static final int RouteErrorcodeRestoreFail = 37;
    public static final int RouteErrorcodeRouteReqExist = 206;
    public static final int RouteErrorcodeSlilentRouteNotMeetCriteria = 23;
    public static final int RouteErrorcodeStartNoRoad = 10;
    public static final int RouteErrorcodeStartNoSupportElectricBike = 101;
    public static final int RouteErrorcodeStartPointError = 3;
    public static final int RouteErrorcodeSuccess = 1;
    public static final int RouteErrorcodeTooFar = 19;
    public static final int RouteErrorcodeUncompressFail = 301;
    public static final int RouteErrorcodeUnicastFail = 1005;
    public static final int RouteErrorcodeUnkonw = 13;
    public static final int RouteErrorcodeUpdatingData = 22;
    public static final int RouteErrorcodeUserCancel = 15;
    public static final int RouteErrorcodeViaPointError = 21;
    public static final int RouteErrorcodeoOfflineRouteCalculating = 26;
    public static final int RouteErrorcodeoOfflineRouteParamError = 27;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RouteErrorcode1 {
    }
}

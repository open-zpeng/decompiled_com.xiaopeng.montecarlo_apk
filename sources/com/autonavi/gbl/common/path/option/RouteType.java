package com.autonavi.gbl.common.path.option;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RouteType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RouteTypeAosRoute = 999;
    public static final int RouteTypeAvoid = 15;
    public static final int RouteTypeChangeJnyPnt = 9;
    public static final int RouteTypeChangeStratege = 3;
    public static final int RouteTypeCommon = 1;
    public static final int RouteTypeDamagedRoad = 7;
    public static final int RouteTypeDispatch = 16;
    public static final int RouteTypeGroupChangeDest = 26;
    public static final int RouteTypeGuideCloudSection = 1001;
    public static final int RouteTypeLimitForbid = 11;
    public static final int RouteTypeLimitForbidOffLine = 13;
    public static final int RouteTypeLimitLine = 6;
    public static final int RouteTypeManualRefresh = 12;
    public static final int RouteTypeMax = 9002;
    public static final int RouteTypeMutiRouteRequest = 14;
    public static final int RouteTypeOnDeletePath = 1000;
    public static final int RouteTypeOnSelectMainPath = 9001;
    public static final int RouteTypeParallelRoad = 4;
    public static final int RouteTypePressure = 8;
    public static final int RouteTypeRestoration = 998;
    public static final int RouteTypeSwitchMode = 21;
    public static final int RouteTypeTMC = 5;
    public static final int RouteTypeUpdateCityData = 10;
    public static final int RouteTypeVoiceAddViaPoint = 23;
    public static final int RouteTypeVoiceChangeDest = 17;
    public static final int RouteTypeYaw = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RouteType1 {
    }
}

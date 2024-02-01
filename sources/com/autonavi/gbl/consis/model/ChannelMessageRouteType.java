package com.autonavi.gbl.consis.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ChannelMessageRouteType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MessageRouteMax = 7999;
    public static final int MessageRouteMin = 7000;
    public static final int MessageRouteResultOnNewRoute = 7001;
    public static final int MessageRouteResultOnNewRouteError = 7002;
    public static final int MessageRouteResultOnSyncRoute = 7201;
    public static final int MessageRouteResultSyncRouteResultFailCallback = 7203;
    public static final int MessageRouteResultSyncRouteResultSuccessCallback = 7202;
    public static final int MessageRouteSetConfig = 7101;
    public static final int MessageRouteSetLocalPlanTime = 7204;
    public static final int MessageRouteSyncRouteOption = 7205;
    public static final int MessageRouteUpdateTmcData = 7301;
    public static final int MessageRouteWeatherOnRecv = 7003;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ChannelMessageRouteType1 {
    }
}

package com.autonavi.gbl.consis.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CHANNEL_MSG_ROUTE_TYPE {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MSG_ROUTE_MAX = 7999;
    public static final int MSG_ROUTE_MIN = 7000;
    public static final int MSG_ROUTE_RESULT_ON_NEW_ROUTE = 7001;
    public static final int MSG_ROUTE_RESULT_ON_NEW_ROUTE_ERROR = 7002;
    public static final int MSG_ROUTE_RESULT_ON_SYNC_ROUTE = 7005;
    public static final int MSG_ROUTE_RESULT_SYNC_ROUTE_RESULT_FAIL_CALLBACK = 7007;
    public static final int MSG_ROUTE_RESULT_SYNC_ROUTE_RESULT_SUCCESS_CALLBACK = 7006;
    public static final int MSG_ROUTE_SET_CONFIG = 7004;
    public static final int MSG_ROUTE_SET_LOCAL_PLAN_TIME = 7008;
    public static final int MSG_ROUTE_SYNC_ROUTE_OPTION = 7009;
    public static final int MSG_ROUTE_UPDATE_TMC_DATA = 7010;
    public static final int MSG_ROUTE_WEATHER_ON_RECV = 7003;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CHANNEL_MSG_ROUTE_TYPE1 {
    }
}

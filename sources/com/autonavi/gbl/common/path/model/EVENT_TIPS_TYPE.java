package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class EVENT_TIPS_TYPE {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int EVENT_FILTERED_BY_CREDIBILITY = -4;
    public static final int EVENT_FILTERED_BY_ROADNAME = -5;
    public static final int EVENT_FILTERED_BY_STATE = -2;
    public static final int EVENT_NOT_ON_PATH = -3;
    public static final int TIPS_ADJUST_SORT = 6;
    public static final int TIPS_EVENT_INVALID = -1;
    public static final int TIPS_EVENT_MAX = 8;
    public static final int TIPS_IN_ROUTE_CLOSED_EVENT_END = 2;
    public static final int TIPS_IN_ROUTE_CLOSED_EVENT_OTHER = 3;
    public static final int TIPS_IN_ROUTE_CLOSED_EVENT_START = 0;
    public static final int TIPS_IN_ROUTE_CLOSED_EVENT_VIA = 1;
    public static final int TIPS_IN_ROUTE_UNCLOSED_EVENT = 5;
    public static final int TIPS_OUT_ROUTE_CLOSED_EVENT = 4;
    public static final int TIPS_TARGET_DISPATCH = 7;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface EVENT_TIPS_TYPE1 {
    }
}

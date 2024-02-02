package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RouteTrafficEvent {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RouteTrafficEventConstruction = 201;
    public static final int RouteTrafficEventImpactTravel = 202;
    public static final int RouteTrafficEventNormal = 101;
    public static final int RouteTrafficEventNotRecommend = 203;
    public static final int RouteTrafficEventObstacle = 505;
    public static final int RouteTrafficEventSerious = 102;
    public static final int RouteTrafficEventSuspected = 104;
    public static final int RouteTrafficEventWater = 501;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RouteTrafficEvent1 {
    }
}

package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RouteTrafficEventType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ROUTE_CONSTRUCTION = 201;
    public static final int ROUTE_CONSTRUCTION_IMPACT_TRAVEL = 202;
    public static final int ROUTE_CONSTRUCTION_NOT_RECOMMENDED_TRAVEL = 203;
    public static final int ROUTE_NORMAL_TRAFFIC_EVENT = 101;
    public static final int ROUTE_ROAD_OBSTACLE = 505;
    public static final int ROUTE_ROAD_WATER = 501;
    public static final int ROUTE_SERIOUS_TRAFFIC_EVENT = 102;
    public static final int ROUTE_SUSPECTED_TRAFFIC_EVENT = 104;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RouteTrafficEventType1 {
    }
}

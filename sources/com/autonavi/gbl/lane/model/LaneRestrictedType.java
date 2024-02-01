package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneRestrictedType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Bus = 1;
    public static final int HOV = 2;
    public static final int HazardousArticle = 5;
    public static final int None = 0;
    public static final int ProhibitedTurn = 9;
    public static final int Taxi = 4;
    public static final int TidalLane = 7;
    public static final int Tram = 6;
    public static final int Truck = 3;
    public static final int VariableLane = 8;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneRestrictedType1 {
    }
}

package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class RoadEdgeType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RoadEdgeTypeBarrier = 8;
    public static final int RoadEdgeTypeCementBlock = 7;
    public static final int RoadEdgeTypeCurb = 5;
    public static final int RoadEdgeTypeGreenBelts = 9;
    public static final int RoadEdgeTypeGuardRail = 3;
    public static final int RoadEdgeTypeLaneLine = 2;
    public static final int RoadEdgeTypeNatural = 6;
    public static final int RoadEdgeTypeNotLaneLine = 10;
    public static final int RoadEdgeTypeNull = 0;
    public static final int RoadEdgeTypeUncertain = 1;
    public static final int RoadEdgeTypeWall = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface RoadEdgeType1 {
    }
}

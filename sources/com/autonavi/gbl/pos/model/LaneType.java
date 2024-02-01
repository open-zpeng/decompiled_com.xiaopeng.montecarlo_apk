package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LaneType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LaneType_BottsDots = 6;
    public static final int LaneType_Dashed = 2;
    public static final int LaneType_DotSolid = 7;
    public static final int LaneType_DoubleMark_Dashed = 5;
    public static final int LaneType_DoubleMark_Solid = 4;
    public static final int LaneType_Invalid = 10;
    public static final int LaneType_RoadEdge = 3;
    public static final int LaneType_SlowDown = 9;
    public static final int LaneType_Solid = 1;
    public static final int LaneType_SolidDot = 8;
    public static final int LaneType_Undecided = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LaneType1 {
    }
}

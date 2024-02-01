package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneStatusDescription {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int NetworkError = 7;
    public static final int NoGuideMatch = 6;
    public static final int NoLNDSData = 5;
    public static final int NoLaneMatch = 1;
    public static final int NoMappingToPathEnd = 4;
    public static final int NoMappingWithAction = 2;
    public static final int NoMappingWithoutAction = 3;
    public static final int Null = -1;
    public static final int StopNavi = 8;
    public static final int Sucess = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneStatusDescription1 {
    }
}

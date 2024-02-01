package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneRenderParamType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CarUpMode = 4;
    public static final int DynamicLevel = 0;
    public static final int DynamicLevelSpeedThreshold = 2;
    public static final int DynamicViewMode = 1;
    public static final int FollowMode = 3;
    public static final int Invalid = -1;
    public static final int LockPitchAngle = 5;
    @Deprecated
    public static final int NaviLine = 6;
    public static final int RoadPolygon = 7;
    public static final int TMCShowStatus = 8;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneRenderParamType1 {
    }
}

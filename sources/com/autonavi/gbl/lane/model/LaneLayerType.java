package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Deprecated
/* loaded from: classes.dex */
public final class LaneLayerType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LANE_LAYER_TYPE_CAMERA = 2;
    public static final int LANE_LAYER_TYPE_CONGESTION = 0;
    public static final int LANE_LAYER_TYPE_MAX = 6;
    public static final int LANE_LAYER_TYPE_ODD = 5;
    public static final int LANE_LAYER_TYPE_TRAVEL_POINT = 4;
    public static final int LANE_LAYER_TYPE_TREVENT = 1;
    public static final int LANE_LAYER_TYPE_TURN = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneLayerType1 {
    }
}

package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneChangeStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LANE_CHANGE_FAIL = 4;
    public static final int LANE_CHANGE_FINISH = 3;
    public static final int LANE_CHANGE_RECOMMEND = 5;
    public static final int LANE_CHANGE_START = 2;
    public static final int LANE_CHANGE_WAIT = 1;
    public static final int LANE_KEEP_WAY = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneChangeStatus1 {
    }
}

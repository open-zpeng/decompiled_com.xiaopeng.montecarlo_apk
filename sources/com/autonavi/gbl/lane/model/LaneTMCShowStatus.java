package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneTMCShowStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    @Deprecated
    public static final int LANE_TMC_SHOW_STATUS_GUIDE_LINE = 1;
    public static final int LANE_TMC_SHOW_STATUS_GUIDE_POLYGON = 2;
    public static final int LANE_TMC_SHOW_STATUS_NULL = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneTMCShowStatus1 {
    }
}

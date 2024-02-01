package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneChangeGuidanceType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int BypassArea = 3;
    public static final int DashSolid = 1;
    public static final int None = 0;
    public static final int SolidDash = 2;
    public static final int SolidLine = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneChangeGuidanceType1 {
    }
}

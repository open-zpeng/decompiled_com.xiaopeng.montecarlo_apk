package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class PositionAdjustStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int POSITION_ADJUST_FAILED = 1;
    public static final int POSITION_ADJUST_NONE = 0;
    public static final int POSITION_ADJUST_SUCCEED = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface PositionAdjustStatus1 {
    }
}

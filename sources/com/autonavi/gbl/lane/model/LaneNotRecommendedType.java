package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneNotRecommendedType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LeftInward = 1;
    public static final int None = 0;
    public static final int RightInward = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneNotRecommendedType1 {
    }
}

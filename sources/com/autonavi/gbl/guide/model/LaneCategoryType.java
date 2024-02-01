package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneCategoryType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LaneTypeBus = 1;
    public static final int LaneTypeNULL = 255;
    public static final int LaneTypeNormal = 0;
    public static final int LaneTypeOther = 2;
    public static final int LaneTypeTidal = 3;
    public static final int LaneTypeVariable = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneCategoryType1 {
    }
}

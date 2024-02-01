package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneDynamicLevelType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LaneDynamicLevelHighSpeed = 1;
    public static final int LaneDynamicLevelLowSpeed = 0;
    public static final int LaneDynamicLevelMax = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneDynamicLevelType1 {
    }
}

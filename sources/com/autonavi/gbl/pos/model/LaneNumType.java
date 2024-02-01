package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LaneNumType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LaneNumIncludeSpecial = 1;
    public static final int LaneNumNotIncludeSpecial = 2;
    public static final int LaneNumTypeNull = 0;
    public static final int LaneNumTypeUncertain = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LaneNumType1 {
    }
}

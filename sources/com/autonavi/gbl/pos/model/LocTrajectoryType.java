package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocTrajectoryType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocTrajectoryDRBack = 2;
    public static final int LocTrajectoryDRFront = 1;
    public static final int LocTrajectoryGNSS = 0;
    public static final int LocTrajectoryNetwork = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocTrajectoryType1 {
    }
}

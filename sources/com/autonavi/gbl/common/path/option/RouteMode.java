package com.autonavi.gbl.common.path.option;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RouteMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RMDrive = 0;
    public static final int RMMix = 6;
    public static final int RMOdd = 5;
    public static final int RMRide = 1;
    public static final int RMRideElectrombile = 3;
    public static final int RMTrunk = 4;
    public static final int RMWalk = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RouteMode1 {
    }
}

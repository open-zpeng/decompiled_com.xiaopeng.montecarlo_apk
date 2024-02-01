package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class NaviType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int NaviTypeCruise = 2;
    public static final int NaviTypeGPS = 0;
    public static final int NaviTypeHealthRide = 4;
    public static final int NaviTypeHealthRun = 3;
    public static final int NaviTypeHealthShareBike = 5;
    public static final int NaviTypeSimulation = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface NaviType1 {
    }
}

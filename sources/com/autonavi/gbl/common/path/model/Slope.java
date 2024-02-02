package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class Slope {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SlopeAscent = 2;
    public static final int SlopeDoNotEnterToll = 16;
    public static final int SlopeDoNotEnterTurnel = 15;
    public static final int SlopeDoNotTurnLeft = 10;
    public static final int SlopeDoNotTurnRight = 11;
    public static final int SlopeDownHill = 3;
    public static final int SlopeFlat = 1;
    public static final int SlopeNULL = 0;
    public static final int SlopeNotAscent = 4;
    public static final int SlopeNotDownHill = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface Slope1 {
    }
}

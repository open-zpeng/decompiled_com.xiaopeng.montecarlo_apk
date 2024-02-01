package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class PointInfoType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AvoidJam = 41;
    public static final int ForbiddenGoStraight = 28;
    public static final int ForbiddenLeft = 24;
    public static final int ForbiddenLeftTurnRound = 26;
    public static final int ForbiddenRight = 25;
    public static final int ForbiddenRightTurnRound = 27;
    public static final int LimitWeight = 23;
    public static final int LimitWidth = 22;
    public static final int PointInfoTypeNotDef = 0;
    public static final int UgcAccident = 4;
    public static final int UgcConstruction = 3;
    public static final int kLimitHeight = 21;
    public static final int kUgcClosed = 2;
    public static final int kUgcWater = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface PointInfoType1 {
    }
}

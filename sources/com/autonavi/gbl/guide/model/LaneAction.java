package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneAction {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LaneActionAhead = 0;
    public static final int LaneActionAheadLUTurn = 9;
    public static final int LaneActionAheadLeft = 2;
    public static final int LaneActionAheadLeftLUTurn = 16;
    public static final int LaneActionAheadLeftRight = 7;
    public static final int LaneActionAheadRUTurn = 10;
    public static final int LaneActionAheadRight = 4;
    public static final int LaneActionAheadRightLUTurn = 19;
    public static final int LaneActionBus = 21;
    public static final int LaneActionDedicated = 24;
    public static final int LaneActionEmpty = 22;
    public static final int LaneActionLUTurn = 5;
    public static final int LaneActionLeft = 1;
    public static final int LaneActionLeftInAhead = 13;
    public static final int LaneActionLeftLUTurn = 11;
    public static final int LaneActionLeftLUturn = 14;
    public static final int LaneActionLeftRUTurn = 20;
    public static final int LaneActionLeftRight = 6;
    public static final int LaneActionLeftRightLUTurn = 18;
    public static final int LaneActionNULL = 255;
    public static final int LaneActionRUTurn = 8;
    public static final int LaneActionReserved = 15;
    public static final int LaneActionRight = 3;
    public static final int LaneActionRightLUTurn = 17;
    public static final int LaneActionRightRUTurn = 12;
    public static final int LaneActionTidal = 25;
    public static final int LaneActionVariable = 23;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneAction1 {
    }
}

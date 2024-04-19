package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MainAction {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MainActionByElevator = 67;
    public static final int MainActionByEscalator = 69;
    public static final int MainActionByStair = 68;
    public static final int MainActionContinue = 8;
    public static final int MainActionCount = 70;
    public static final int MainActionEnterBuilding = 65;
    public static final int MainActionEntryRing = 11;
    public static final int MainActionLeaveBuilding = 66;
    public static final int MainActionLeaveRing = 12;
    public static final int MainActionMergeLeft = 9;
    public static final int MainActionMergeRight = 10;
    public static final int MainActionNULL = 0;
    public static final int MainActionPlugContinue = 14;
    public static final int MainActionSlightLeft = 3;
    public static final int MainActionSlightRight = 4;
    public static final int MainActionSlow = 13;
    public static final int MainActionTurnHardLeft = 5;
    public static final int MainActionTurnHardRight = 6;
    public static final int MainActionTurnLeft = 1;
    public static final int MainActionTurnRight = 2;
    public static final int MainActionUTurn = 7;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MainAction1 {
    }
}

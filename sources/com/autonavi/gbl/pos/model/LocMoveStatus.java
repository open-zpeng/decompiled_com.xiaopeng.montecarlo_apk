package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocMoveStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocMoveBack = 2;
    public static final int LocMoveInvalid = 0;
    public static final int LocMoveLeft = 4;
    public static final int LocMoveNormal = 1;
    public static final int LocMoveRight = 8;
    public static final int LocMoveStop = 32;
    public static final int LocMoveTurnRound = 16;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocMoveStatus1 {
    }
}

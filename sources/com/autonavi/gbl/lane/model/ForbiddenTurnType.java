package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ForbiddenTurnType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Left = 1;
    public static final int LeftUTurn = 3;
    public static final int None = 0;
    public static final int Right = 2;
    public static final int RightUTurn = 4;
    public static final int Straight = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ForbiddenTurnType1 {
    }
}

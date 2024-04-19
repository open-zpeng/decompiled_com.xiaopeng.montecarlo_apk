package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LimitType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LimitTypeHigh = 0;
    public static final int LimitTypeNoLeftUTurn = 5;
    public static final int LimitTypeNoRightUTurn = 6;
    public static final int LimitTypeNoStraight = 7;
    public static final int LimitTypeNoTurnLeft = 3;
    public static final int LimitTypeNoTurnRight = 4;
    public static final int LimitTypeWeight = 2;
    public static final int LimitTypeWide = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LimitType1 {
    }
}

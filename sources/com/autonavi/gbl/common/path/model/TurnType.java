package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TurnType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int TurnTypeLeft = 1;
    public static final int TurnTypeNULL = 0;
    public static final int TurnTypeRight = 2;
    public static final int TurnTypeUTurn = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TurnType1 {
    }
}

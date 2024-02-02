package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapGestureState {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapGestureStateBegan = 1;
    public static final int MapGestureStateCancelled = 4;
    public static final int MapGestureStateChanged = 2;
    public static final int MapGestureStateEnded = 3;
    public static final int MapGestureStateFailed = 5;
    public static final int MapGestureStatePossible = 0;
    public static final int MapGestureStateRecognized = 6;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapGestureState1 {
    }
}

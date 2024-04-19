package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class EAMapGestureState {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int EAMapGestureStateBegan = 1;
    public static final int EAMapGestureStateCancelled = 4;
    public static final int EAMapGestureStateChanged = 2;
    public static final int EAMapGestureStateEnded = 3;
    public static final int EAMapGestureStateFailed = 5;
    public static final int EAMapGestureStatePossible = 0;
    public static final int EAMapGestureStateRecognized = 6;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface EAMapGestureState1 {
    }
}

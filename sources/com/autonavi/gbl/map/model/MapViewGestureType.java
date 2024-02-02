package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapViewGestureType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapViewGestureTypeMove = 0;
    public static final int MapViewGestureTypeRotate = 2;
    public static final int MapViewGestureTypeScale = 1;
    public static final int MapViewGestureTypeTilt = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapViewGestureType1 {
    }
}

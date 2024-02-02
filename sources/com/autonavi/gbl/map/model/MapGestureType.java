package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapGestureType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapGestureTypeCameraHeader = 6;
    public static final int MapGestureTypeLongPress = 7;
    public static final int MapGestureTypeMove = 3;
    public static final int MapGestureTypePinchZoom = 4;
    public static final int MapGestureTypeRotation = 5;
    public static final int MapGestureTypeSingleTap = 8;
    public static final int MapGestureTypeSingleZoom = 9;
    public static final int MapGestureTypeTapZoomIn = 1;
    public static final int MapGestureTypeTapZoomOut = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapGestureType1 {
    }
}

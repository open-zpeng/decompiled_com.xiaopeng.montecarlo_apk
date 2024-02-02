package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapLayerPoiAnimation {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapLayerPOIAnimationBounce = 3;
    public static final int MapLayerPOIAnimationDoubleRaise = 5;
    public static final int MapLayerPOIAnimationDrop = 1;
    public static final int MapLayerPOIAnimationDropAndOverShoot = 4;
    public static final int MapLayerPOIAnimationExpandLong = 8;
    public static final int MapLayerPOIAnimationExpandShort = 9;
    public static final int MapLayerPOIAnimationFade = 6;
    public static final int MapLayerPOIAnimationGrow = 2;
    public static final int MapLayerPOIAnimationNone = 0;
    public static final int MapLayerPOIAnimationPopOut = 7;
    public static final int MapLayerPOIAnimationShrink = 10;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapLayerPoiAnimation1 {
    }
}

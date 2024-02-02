package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RouteLayerStyleType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int EaglEye_HightLight = 3;
    public static final int EaglEye_Normal = 2;
    public static final int EaglEye_Offline = 6;
    public static final int EaglEye_Offline_HightLight = 7;
    public static final int Main_HightLight = 1;
    public static final int Main_Normal = 0;
    public static final int Main_Offline = 4;
    public static final int Main_Offline_HightLight = 5;
    public static final int RainbowLine_HightLight = 8;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RouteLayerStyleType1 {
    }
}

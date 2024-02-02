package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LayerDrawPriority {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LayerDrawPriorityAfterBackGround = 10;
    public static final int LayerDrawPriorityAfterBuilding = 80;
    public static final int LayerDrawPriorityAfterLabel = 120;
    public static final int LayerDrawPriorityAfterRoad = 40;
    public static final int LayerDrawPriorityBeforeBackGround = 0;
    public static final int LayerDrawPriorityBeforeBuilding = 60;
    public static final int LayerDrawPriorityBeforeLabel = 100;
    public static final int LayerDrawPriorityBeforeRoad = 20;
    public static final int LayerDrawPriorityBeforeSky = 50;
    public static final int LayerDrawPriorityRenderMapOver = 140;
    public static final int LayerDrawPriorityTop = 1000;
    public static final int LayerDrawPriorityWidget = 65535;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LayerDrawPriority1 {
    }
}

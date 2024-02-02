package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapRenderMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapRenderCount = 4;
    public static final int MapRenderModeAnimation = 2;
    public static final int MapRenderModeGestureAction = 3;
    public static final int MapRenderModeNavi = 1;
    public static final int MapRenderModeNormal = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapRenderMode1 {
    }
}

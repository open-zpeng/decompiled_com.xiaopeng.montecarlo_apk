package com.autonavi.gbl.multi.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class MapViewModeConfig {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapViewMode2DCarUp = 1;
    public static final int MapViewMode2DNorthUp = 0;
    public static final int MapViewMode3DCarUp = 2;
    public static final int MapViewModeFollowMain = 3;
    public static final int MapViewModeIgnore = -1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface MapViewModeConfig1 {
    }
}

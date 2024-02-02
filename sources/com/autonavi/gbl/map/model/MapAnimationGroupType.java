package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapAnimationGroupType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapAnimationAll = 5;
    public static final int MapAnimationGeoAndScreen = 4;
    public static final int MapAnimationGroup = 0;
    public static final int MapAnimationMove = 1;
    public static final int MapAnimationPivotZoom = 2;
    public static final int MapAnimationZoomRotate = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapAnimationGroupType1 {
    }
}

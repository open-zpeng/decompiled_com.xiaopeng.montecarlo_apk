package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class MapviewMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapviewMode3D = 2;
    public static final int MapviewModeCar = 1;
    public static final int MapviewModeInvalid = -1;
    public static final int MapviewModeNorth = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface MapviewMode1 {
    }
}

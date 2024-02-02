package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CarMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CarMode2D = 0;
    public static final int CarMode3D = 1;
    public static final int CarModeSkeleton = 2;
    public static final int CarModeSpeed = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CarMode1 {
    }
}

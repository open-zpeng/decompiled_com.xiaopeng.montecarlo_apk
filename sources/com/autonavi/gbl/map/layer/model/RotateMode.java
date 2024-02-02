package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RotateMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RotateModeMap = 1;
    public static final int RotateModeNone = 0;
    public static final int RotateModeX = 2;
    public static final int RotateModeXZ = 4;
    public static final int RotateModeZ = 3;
    public static final int RotateModeZ_FOLLOW_SELF = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RotateMode1 {
    }
}

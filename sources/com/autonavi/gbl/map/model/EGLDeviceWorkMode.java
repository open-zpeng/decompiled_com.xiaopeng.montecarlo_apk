package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class EGLDeviceWorkMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int EGLDeviceWorkMode_WithOutThreadWithoutEGLContextDrawNotIn = 3;
    public static final int EGLDeviceWorkMode_WithThreadWithEGLContextDrawIn = 0;
    public static final int EGLDeviceWorkMode_WithThreadWithoutEGLContextDrawNotIn = 2;
    public static final int EGLDeviceWorkMode_WithoutThreadWithEGLContextDrawNotIn = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface EGLDeviceWorkMode1 {
    }
}

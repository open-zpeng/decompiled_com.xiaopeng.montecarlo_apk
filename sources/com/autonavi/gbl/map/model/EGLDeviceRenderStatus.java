package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class EGLDeviceRenderStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int EGLDeviceRenderStatusAfterDrawMap = 3;
    public static final int EGLDeviceRenderStatusAfterMakeCurrent = 1;
    public static final int EGLDeviceRenderStatusAfterSwapBuffer = 5;
    public static final int EGLDeviceRenderStatusBeforeDrawMap = 2;
    public static final int EGLDeviceRenderStatusBeforeMakeCurrent = 0;
    public static final int EGLDeviceRenderStatusBeforeSwapBuffer = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface EGLDeviceRenderStatus1 {
    }
}

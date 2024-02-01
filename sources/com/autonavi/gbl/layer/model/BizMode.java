package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class BizMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int BizModeAR = 2;
    public static final int BizModeCruise2D = 4;
    public static final int BizModeCruise3D = 5;
    public static final int BizModeDefault = 0;
    public static final int BizModeIndoor = 3;
    public static final int BizModeSimple = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface BizMode1 {
    }
}

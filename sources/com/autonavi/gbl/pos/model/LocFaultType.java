package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocFaultType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocFaultA3DLost = 3;
    public static final int LocFaultGYRLost = 4;
    public static final int LocFaultNull = 0;
    public static final int LocFaultPosInvalid = 2;
    public static final int LocFaultPosLost = 1;
    public static final int LocFaultPulseLost = 5;
    public static final int LocFaultVisLost = 6;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocFaultType1 {
    }
}

package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocDrType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocDrTypeDR = 1;
    public static final int LocDrTypeDRALONG = 4;
    public static final int LocDrTypeDRGNSS = 2;
    public static final int LocDrTypeDRMM = 3;
    public static final int LocDrTypeGNSS = 0;
    public static final int LocDrTypeUnknow = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocDrType1 {
    }
}

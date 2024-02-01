package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ELaneAlgType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ELaneAlgASP = 8;
    public static final int ELaneAlgGF = 4;
    public static final int ELaneAlgHSP = 2;
    public static final int ELaneAlgLSP = 1;
    public static final int ELaneAlgNF = 5;
    public static final int ELaneAlgNone = 0;
    public static final int ELaneAlgRF = 7;
    public static final int ELaneAlgSF = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ELaneAlgType1 {
    }
}

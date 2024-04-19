package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocPoleType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LOC_POLE_COUNT = 255;
    public static final int LOC_POLE_DELINEATOR_POST = 2;
    public static final int LOC_POLE_GANTRY_POLE = 4;
    public static final int LOC_POLE_GUARDRAIL_POST = 0;
    public static final int LOC_POLE_LIGHT_POLE = 1;
    public static final int LOC_POLE_OTHER = 6;
    public static final int LOC_POLE_REFLECTOR_POST = 3;
    public static final int LOC_POLE_SIGNPOST = 5;
    public static final int LOC_POLE_UNCLASSIFIED = 7;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocPoleType1 {
    }
}

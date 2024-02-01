package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LineType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CongestionCongest = 3;
    public static final int CongestionHard = 4;
    public static final int CongestionJam = 5;
    public static final int CongestionSmooth = 2;
    public static final int CongestionUnknow = 1;
    public static final int LineTypeNotDef = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LineType1 {
    }
}

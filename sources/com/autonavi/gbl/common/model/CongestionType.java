package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CongestionType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int kCongestionCongest = 3;
    public static final int kCongestionHard = 4;
    public static final int kCongestionJam = 5;
    public static final int kCongestionNotDef = 0;
    public static final int kCongestionSmooth = 2;
    public static final int kCongestionUnknow = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CongestionType1 {
    }
}

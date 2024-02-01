package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LaneProbLevel {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LaneProbLevelHigh = 3;
    public static final int LaneProbLevelInvalid = 0;
    public static final int LaneProbLevelLow = 1;
    public static final int LaneProbLevelMiddle = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LaneProbLevel1 {
    }
}

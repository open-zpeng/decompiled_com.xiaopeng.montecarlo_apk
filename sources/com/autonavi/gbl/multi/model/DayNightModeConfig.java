package com.autonavi.gbl.multi.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class DayNightModeConfig {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int DayNightModeAuto = 1;
    public static final int DayNightModeDay = 3;
    public static final int DayNightModeFollowMain = 0;
    public static final int DayNightModeNight = 2;
    public static final int DayNightModeUndefine = -1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface DayNightModeConfig1 {
    }
}

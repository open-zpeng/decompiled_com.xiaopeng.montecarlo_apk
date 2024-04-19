package com.autonavi.gbl.util.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class TimeSourceFlag {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int TIME_SOURCE_BOTH = 3;
    public static final int TIME_SOURCE_LOCALTIME = 2;
    public static final int TIME_SOURCE_TICKCOUNT = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface TimeSourceFlag1 {
    }
}

package com.autonavi.gbl.util.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class TimeSourceType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int TIME_SOURCE_TYPE_GPS = 2;
    public static final int TIME_SOURCE_TYPE_LOCAL = 4;
    public static final int TIME_SOURCE_TYPE_NET = 1;
    public static final int TIME_SOURCE_TYPE_NONE = 0;
    public static final int TIME_SOURCE_TYPE_SOURCE = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface TimeSourceType1 {
    }
}

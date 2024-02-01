package com.autonavi.gbl.util.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class EGcoLogLevel {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int GCO_LOG_DEBUG = 4;
    public static final int GCO_LOG_ERROR = 1;
    public static final int GCO_LOG_INFO = 3;
    public static final int GCO_LOG_NULL = 0;
    public static final int GCO_LOG_VERBOSE = 5;
    public static final int GCO_LOG_WARNING = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface EGcoLogLevel1 {
    }
}

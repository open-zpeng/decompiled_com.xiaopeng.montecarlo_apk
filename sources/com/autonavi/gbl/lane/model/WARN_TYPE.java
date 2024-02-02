package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class WARN_TYPE {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int WARN_TYPE_AEB = 1;
    public static final int WARN_TYPE_BSD = 3;
    public static final int WARN_TYPE_FCW = 0;
    public static final int WARN_TYPE_RCW = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface WARN_TYPE1 {
    }
}

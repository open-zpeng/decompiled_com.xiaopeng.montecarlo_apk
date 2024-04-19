package com.autonavi.gbl.multi.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class TmcConfig {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int TmcConfigIgnore = -1;
    public static final int TmcDisable = 2;
    public static final int TmcEnable = 1;
    public static final int TmcFollowMain = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface TmcConfig1 {
    }
}

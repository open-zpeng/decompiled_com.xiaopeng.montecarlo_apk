package com.autonavi.gbl.information.trade.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class DiningRefundStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Failed = 3;
    public static final int Init = 0;
    public static final int Process = 1;
    public static final int Success = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface DiningRefundStatus1 {
    }
}

package com.autonavi.gbl.information.trade.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CouponType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int FullReduction = 1;
    public static final int InstantReduction = 2;
    public static final int Unknown = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CouponType1 {
    }
}

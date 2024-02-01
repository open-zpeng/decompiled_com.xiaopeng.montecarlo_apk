package com.autonavi.gbl.information.trade.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TradeDiscountType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Unknown = 0;
    public static final int UseCoupon = 1;
    public static final int UseDiscountPrice = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TradeDiscountType1 {
    }
}

package com.autonavi.gbl.information.trade.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class OrderStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Closed = 8500;
    public static final int PayCancel = 8100;
    public static final int PayConfirm = 5000;
    public static final int PayDone = 8000;
    public static final int PayWaiting = 2000;
    public static final int RefundDone = 8400;
    public static final int RefundWaiting = 5400;
    public static final int Unknown = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface OrderStatus1 {
    }
}

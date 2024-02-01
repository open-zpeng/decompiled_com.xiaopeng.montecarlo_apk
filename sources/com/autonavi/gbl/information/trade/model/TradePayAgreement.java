package com.autonavi.gbl.information.trade.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TradePayAgreement {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int FacePay = 2;
    public static final int NormalPay = 0;
    public static final int QuickPay = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TradePayAgreement1 {
    }
}

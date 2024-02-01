package com.autonavi.gbl.information.trade.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class PayChannel {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AliPay = 1;
    public static final int Unknown = -1;
    public static final int WeiXinPay = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface PayChannel1 {
    }
}

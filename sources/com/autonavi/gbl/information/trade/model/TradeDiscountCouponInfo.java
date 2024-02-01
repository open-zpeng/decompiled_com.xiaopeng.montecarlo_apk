package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TradeDiscountCouponInfo implements Serializable {
    public boolean isEffect;
    public long recordId;

    public TradeDiscountCouponInfo() {
        this.isEffect = true;
        this.recordId = 0L;
    }

    public TradeDiscountCouponInfo(boolean z, long j) {
        this.isEffect = z;
        this.recordId = j;
    }
}

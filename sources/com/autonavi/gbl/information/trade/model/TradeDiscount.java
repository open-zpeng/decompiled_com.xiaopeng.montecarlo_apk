package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TradeDiscount implements Serializable {
    public TradeDiscountCouponInfo couponInfo;
    public TradeDiscountInstantReduction instantReduction;

    public TradeDiscount() {
        this.instantReduction = new TradeDiscountInstantReduction();
        this.couponInfo = new TradeDiscountCouponInfo();
    }

    public TradeDiscount(TradeDiscountInstantReduction tradeDiscountInstantReduction, TradeDiscountCouponInfo tradeDiscountCouponInfo) {
        this.instantReduction = tradeDiscountInstantReduction;
        this.couponInfo = tradeDiscountCouponInfo;
    }
}

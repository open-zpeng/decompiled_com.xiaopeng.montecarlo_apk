package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiscountRule implements Serializable {
    public TradePrice price;
    public TradePrice threshold;

    public DiscountRule() {
        this.threshold = new TradePrice();
        this.price = new TradePrice();
    }

    public DiscountRule(TradePrice tradePrice, TradePrice tradePrice2) {
        this.threshold = tradePrice;
        this.price = tradePrice2;
    }
}

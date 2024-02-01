package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TradePriceInfo implements Serializable {
    public TradePrice couponAmount;
    public TradePrice discountAmount;
    public TradePrice payAmount;

    public TradePriceInfo() {
        this.payAmount = new TradePrice();
        this.discountAmount = new TradePrice();
        this.couponAmount = new TradePrice();
    }

    public TradePriceInfo(TradePrice tradePrice, TradePrice tradePrice2, TradePrice tradePrice3) {
        this.payAmount = tradePrice;
        this.discountAmount = tradePrice2;
        this.couponAmount = tradePrice3;
    }
}

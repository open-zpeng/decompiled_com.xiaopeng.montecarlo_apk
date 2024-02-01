package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningRefundAmountInfo implements Serializable {
    public TradePrice amount;
    public TradePrice damages;

    public DiningRefundAmountInfo() {
        this.amount = new TradePrice();
        this.damages = new TradePrice();
    }

    public DiningRefundAmountInfo(TradePrice tradePrice, TradePrice tradePrice2) {
        this.amount = tradePrice;
        this.damages = tradePrice2;
    }
}

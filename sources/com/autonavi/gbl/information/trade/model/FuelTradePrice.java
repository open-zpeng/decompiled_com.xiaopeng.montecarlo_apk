package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FuelTradePrice implements Serializable {
    public TradeDiscount discount;
    public TradePrice inputAmount;
    public OilGunNo oilGunNo;
    public String oilNo;

    public FuelTradePrice() {
        this.oilNo = "92#";
        this.inputAmount = new TradePrice();
        this.oilGunNo = new OilGunNo();
        this.discount = new TradeDiscount();
    }

    public FuelTradePrice(String str, TradePrice tradePrice, OilGunNo oilGunNo, TradeDiscount tradeDiscount) {
        this.oilNo = str;
        this.inputAmount = tradePrice;
        this.oilGunNo = oilGunNo;
        this.discount = tradeDiscount;
    }
}

package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningTradePriceInfo extends TradePriceInfo implements Serializable {
    public TradePrice originAmount = new TradePrice();
    public TradePrice totalDiscountAmount = new TradePrice();
}

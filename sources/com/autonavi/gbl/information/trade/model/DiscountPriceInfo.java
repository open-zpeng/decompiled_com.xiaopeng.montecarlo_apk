package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DiscountPriceInfo extends TradePriceInfo implements Serializable {
    public TradePrice inputAmount = new TradePrice();
    public TradePrice serviceFee = new TradePrice();
    public TradeDiscountCouponInfo couponInfo = new TradeDiscountCouponInfo();
    public TradePrice realDiscountAmount = new TradePrice();
    public ArrayList<DiscountRule> discountRule = new ArrayList<>();
}

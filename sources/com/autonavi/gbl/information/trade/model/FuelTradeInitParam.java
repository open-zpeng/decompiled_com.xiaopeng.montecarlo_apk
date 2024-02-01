package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FuelTradeInitParam extends TradeInitParam implements Serializable {
    public String srcType = "";
    public String poiName = "";
    public OrderInitParam orderInitParam = new OrderInitParam();
}

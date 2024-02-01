package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OrderDiningInformation extends OrderInformation implements Serializable {
    public String poiId = "";
    public TradePrice orderAmount = new TradePrice();
    public TradePrice originAmount = new TradePrice();
    public OrderTimeInformation orderTime = new OrderTimeInformation();
    public ArrayList<OrderProductInformation> orderProducts = new ArrayList<>();
}

package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningOrderCancelRequest extends OrderCancelRequest implements Serializable {
    public String orderId = "";
    public CancelTradeReason reason = new CancelTradeReason();

    public DiningOrderCancelRequest() {
        this.bizType = 2;
    }
}

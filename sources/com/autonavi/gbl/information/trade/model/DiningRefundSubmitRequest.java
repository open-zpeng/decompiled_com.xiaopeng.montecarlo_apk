package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningRefundSubmitRequest extends OrderRefundSubmitRequest implements Serializable {
    public String orderId = "";
    public CancelTradeReason reason = new CancelTradeReason();
    public int refundCount = 0;

    public DiningRefundSubmitRequest() {
        this.bizType = 2;
    }
}

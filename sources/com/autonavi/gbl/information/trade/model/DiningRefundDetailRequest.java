package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningRefundDetailRequest extends OrderRefundDetailRequest implements Serializable {
    public String orderId = "";

    public DiningRefundDetailRequest() {
        this.bizType = 2;
    }
}

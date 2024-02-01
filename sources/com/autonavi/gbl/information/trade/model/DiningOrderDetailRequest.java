package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningOrderDetailRequest extends OrderDetailRequest implements Serializable {
    public String orderId = "";

    public DiningOrderDetailRequest() {
        this.bizType = 2;
    }
}

package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FuelOrderDetailRequest extends OrderDetailRequest implements Serializable {
    public String orderId = "";

    public FuelOrderDetailRequest() {
        this.bizType = 1;
    }
}

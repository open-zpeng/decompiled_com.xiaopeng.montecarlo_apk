package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningOrderCancelResult extends OrderCancelResult implements Serializable {
    public String orderId = "";
    public boolean result = false;

    public DiningOrderCancelResult() {
        this.bizType = 2;
    }
}

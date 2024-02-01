package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningOrderDetailResult extends OrderDetailResult implements Serializable {
    public OrderDiningInformation order = new OrderDiningInformation();
    public OrderExtendInformation orderExtend = new OrderExtendInformation();

    public DiningOrderDetailResult() {
        this.bizType = 2;
    }
}

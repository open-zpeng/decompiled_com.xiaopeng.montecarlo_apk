package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FuelOrderDetailResult extends OrderDetailResult implements Serializable {
    public OrderInformation order = new OrderInformation();
    public OrderExtendInformation orderExtend = new OrderExtendInformation();

    public FuelOrderDetailResult() {
        this.bizType = 1;
    }
}

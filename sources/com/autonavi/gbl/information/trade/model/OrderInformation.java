package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.trade.model.OrderStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class OrderInformation implements Serializable {
    public String orderId;
    public String orderName;
    @OrderStatus.OrderStatus1
    public int status;
    public String statusDescription;

    public OrderInformation() {
        this.status = 0;
        this.orderId = "";
        this.statusDescription = "";
        this.orderName = "";
    }

    public OrderInformation(@OrderStatus.OrderStatus1 int i, String str, String str2, String str3) {
        this.status = i;
        this.orderId = str;
        this.statusDescription = str2;
        this.orderName = str3;
    }
}

package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningRefundPageRequest extends OrderRefundPageRequest implements Serializable {
    public String orderId = "";

    public DiningRefundPageRequest() {
        this.bizType = 2;
    }
}

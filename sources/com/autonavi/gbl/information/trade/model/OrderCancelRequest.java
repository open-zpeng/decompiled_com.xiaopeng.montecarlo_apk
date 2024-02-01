package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.model.InformationBizType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class OrderCancelRequest implements Serializable {
    @InformationBizType.InformationBizType1
    public int bizType;

    public OrderCancelRequest() {
        this.bizType = 0;
    }

    public OrderCancelRequest(@InformationBizType.InformationBizType1 int i) {
        this.bizType = i;
    }
}

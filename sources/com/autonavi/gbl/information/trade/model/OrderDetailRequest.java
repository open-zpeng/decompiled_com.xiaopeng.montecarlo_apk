package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.model.InformationBizType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class OrderDetailRequest implements Serializable {
    @InformationBizType.InformationBizType1
    public int bizType;

    public OrderDetailRequest() {
        this.bizType = 0;
    }

    public OrderDetailRequest(@InformationBizType.InformationBizType1 int i) {
        this.bizType = i;
    }
}

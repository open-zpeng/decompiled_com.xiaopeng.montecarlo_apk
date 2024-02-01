package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ObtainedCouponRequest implements Serializable {
    public int pageNum;
    public int pageSize;

    public ObtainedCouponRequest() {
        this.pageNum = 1;
        this.pageSize = 20;
    }

    public ObtainedCouponRequest(int i, int i2) {
        this.pageNum = i;
        this.pageSize = i2;
    }
}

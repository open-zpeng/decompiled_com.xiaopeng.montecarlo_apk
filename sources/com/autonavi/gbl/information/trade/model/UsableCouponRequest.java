package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class UsableCouponRequest implements Serializable {
    public double orderPrice;
    public String poiId;
    public String srcType;

    public UsableCouponRequest() {
        this.orderPrice = 0.0d;
        this.poiId = "";
        this.srcType = "";
    }

    public UsableCouponRequest(double d, String str, String str2) {
        this.orderPrice = d;
        this.poiId = str;
        this.srcType = str2;
    }
}

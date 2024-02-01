package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ObtainableCouponRequest implements Serializable {
    public String adcode;
    public String poiId;

    public ObtainableCouponRequest() {
        this.poiId = "";
        this.adcode = "";
    }

    public ObtainableCouponRequest(String str, String str2) {
        this.poiId = str;
        this.adcode = str2;
    }
}

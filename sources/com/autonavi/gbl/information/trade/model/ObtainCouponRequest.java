package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ObtainCouponRequest implements Serializable {
    public ArrayList<String> couponIds;

    public ObtainCouponRequest() {
        this.couponIds = new ArrayList<>();
    }

    public ObtainCouponRequest(ArrayList<String> arrayList) {
        this.couponIds = arrayList;
    }
}

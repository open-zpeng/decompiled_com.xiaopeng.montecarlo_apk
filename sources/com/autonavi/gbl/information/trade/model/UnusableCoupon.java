package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UnusableCoupon implements Serializable {
    public ArrayList<ObtainableCouponItem> couponItems;
    public String reason;

    public UnusableCoupon() {
        this.reason = "";
        this.couponItems = new ArrayList<>();
    }

    public UnusableCoupon(String str, ArrayList<ObtainableCouponItem> arrayList) {
        this.reason = str;
        this.couponItems = arrayList;
    }
}

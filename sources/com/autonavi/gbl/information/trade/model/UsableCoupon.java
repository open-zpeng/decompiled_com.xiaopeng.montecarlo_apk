package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UsableCoupon implements Serializable {
    public ArrayList<ObtainableCouponItem> couponItems;

    public UsableCoupon() {
        this.couponItems = new ArrayList<>();
    }

    public UsableCoupon(ArrayList<ObtainableCouponItem> arrayList) {
        this.couponItems = arrayList;
    }
}

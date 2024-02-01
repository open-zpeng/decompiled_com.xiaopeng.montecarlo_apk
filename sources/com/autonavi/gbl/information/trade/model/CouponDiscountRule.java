package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CouponDiscountRule implements Serializable {
    public double discount;
    public double threshold;

    public CouponDiscountRule() {
        this.discount = 0.0d;
        this.threshold = 0.0d;
    }

    public CouponDiscountRule(double d, double d2) {
        this.discount = d;
        this.threshold = d2;
    }
}

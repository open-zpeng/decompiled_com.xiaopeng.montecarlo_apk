package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcFuelCreateCouponVo implements Serializable {
    public double amount;
    public String couponId;
    public String cpCouponId;
    public String recordId;

    public WsTcFuelCreateCouponVo() {
        this.recordId = "";
        this.couponId = "";
        this.cpCouponId = "";
        this.amount = 0.0d;
    }

    public WsTcFuelCreateCouponVo(String str, String str2, String str3, double d) {
        this.recordId = str;
        this.couponId = str2;
        this.cpCouponId = str3;
        this.amount = d;
    }
}

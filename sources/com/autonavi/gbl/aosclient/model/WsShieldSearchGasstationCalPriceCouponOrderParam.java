package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceCouponOrderParam implements Serializable {
    public int amount;
    public int couponId;
    public String cpCouponId;
    public int recordId;

    public WsShieldSearchGasstationCalPriceCouponOrderParam() {
        this.recordId = 0;
        this.couponId = 0;
        this.cpCouponId = "";
        this.amount = 0;
    }

    public WsShieldSearchGasstationCalPriceCouponOrderParam(int i, int i2, String str, int i3) {
        this.recordId = i;
        this.couponId = i2;
        this.cpCouponId = str;
        this.amount = i3;
    }
}

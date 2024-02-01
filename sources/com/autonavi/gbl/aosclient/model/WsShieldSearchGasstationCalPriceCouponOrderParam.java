package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceCouponOrderParam implements Serializable {
    public int amount;
    public long couponId;
    public String cpCouponId;
    public long recordId;

    public WsShieldSearchGasstationCalPriceCouponOrderParam() {
        this.recordId = 0L;
        this.couponId = 0L;
        this.cpCouponId = "";
        this.amount = 0;
    }

    public WsShieldSearchGasstationCalPriceCouponOrderParam(long j, long j2, String str, int i) {
        this.recordId = j;
        this.couponId = j2;
        this.cpCouponId = str;
        this.amount = i;
    }
}

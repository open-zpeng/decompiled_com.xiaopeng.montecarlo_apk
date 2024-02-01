package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsIcsLifeCouponRecvListCouponListDisRule implements Serializable {
    public double disPrice;
    public double sPrice;

    public WsIcsLifeCouponRecvListCouponListDisRule() {
        this.disPrice = 0.0d;
        this.sPrice = 0.0d;
    }

    public WsIcsLifeCouponRecvListCouponListDisRule(double d, double d2) {
        this.disPrice = d;
        this.sPrice = d2;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsIcsLifeCouponOptionsUsefulDisRule implements Serializable {
    public double disPrice;
    public int sPrice;

    public WsIcsLifeCouponOptionsUsefulDisRule() {
        this.disPrice = 0.0d;
        this.sPrice = 0;
    }

    public WsIcsLifeCouponOptionsUsefulDisRule(double d, int i) {
        this.disPrice = d;
        this.sPrice = i;
    }
}

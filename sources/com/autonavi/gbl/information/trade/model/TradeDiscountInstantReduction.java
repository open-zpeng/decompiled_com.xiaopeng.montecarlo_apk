package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TradeDiscountInstantReduction implements Serializable {
    public boolean isEffect;

    public TradeDiscountInstantReduction() {
        this.isEffect = true;
    }

    public TradeDiscountInstantReduction(boolean z) {
        this.isEffect = z;
    }
}

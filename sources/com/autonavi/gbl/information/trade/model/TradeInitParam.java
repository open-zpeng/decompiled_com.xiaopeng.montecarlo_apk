package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TradeInitParam implements Serializable {
    public String poiId;

    public TradeInitParam() {
        this.poiId = "";
    }

    public TradeInitParam(String str) {
        this.poiId = str;
    }
}

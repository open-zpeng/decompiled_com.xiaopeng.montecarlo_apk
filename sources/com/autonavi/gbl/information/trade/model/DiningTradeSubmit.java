package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningTradeSubmit implements Serializable {
    public String alipayUid;

    public DiningTradeSubmit() {
        this.alipayUid = "";
    }

    public DiningTradeSubmit(String str) {
        this.alipayUid = str;
    }
}

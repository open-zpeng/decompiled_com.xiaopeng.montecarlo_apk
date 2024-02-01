package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CancelTradeReason implements Serializable {
    public String code;
    public String description;

    public CancelTradeReason() {
        this.description = "";
        this.code = "";
    }

    public CancelTradeReason(String str, String str2) {
        this.description = str;
        this.code = str2;
    }
}

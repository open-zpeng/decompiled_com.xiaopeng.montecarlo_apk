package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningTradeSubErrorInfo implements Serializable {
    public int subErrorCode;
    public String subErrorDetail;

    public DiningTradeSubErrorInfo() {
        this.subErrorCode = 16777215;
        this.subErrorDetail = "";
    }

    public DiningTradeSubErrorInfo(int i, String str) {
        this.subErrorCode = i;
        this.subErrorDetail = str;
    }
}

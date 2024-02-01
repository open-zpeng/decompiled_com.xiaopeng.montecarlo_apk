package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningRefundDetailTextInfo implements Serializable {
    public String reason;
    public String subTitle;
    public String title;

    public DiningRefundDetailTextInfo() {
        this.title = "";
        this.subTitle = "";
        this.reason = "";
    }

    public DiningRefundDetailTextInfo(String str, String str2, String str3) {
        this.title = str;
        this.subTitle = str2;
        this.reason = str3;
    }
}

package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningOrderAgreementInfo implements Serializable {
    public String name;
    public String tip;
    public String url;

    public DiningOrderAgreementInfo() {
        this.name = "";
        this.url = "";
        this.tip = "";
    }

    public DiningOrderAgreementInfo(String str, String str2, String str3) {
        this.name = str;
        this.url = str2;
        this.tip = str3;
    }
}

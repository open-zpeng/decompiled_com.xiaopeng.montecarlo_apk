package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class OrderConfInfo implements Serializable {
    public String cancelText;
    public String okText;
    public String schema;
    public String text;

    public OrderConfInfo() {
        this.schema = "";
        this.text = "";
        this.okText = "";
        this.cancelText = "";
    }

    public OrderConfInfo(String str, String str2, String str3, String str4) {
        this.schema = str;
        this.text = str2;
        this.okText = str3;
        this.cancelText = str4;
    }
}

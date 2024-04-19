package com.autonavi.gbl.user.usertrack.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SummaryModuleDesc implements Serializable {
    public String bgColor;
    public String color;
    public String text;

    public SummaryModuleDesc() {
        this.text = "";
        this.color = "";
        this.bgColor = "";
    }

    public SummaryModuleDesc(String str, String str2, String str3) {
        this.text = str;
        this.color = str2;
        this.bgColor = str3;
    }
}

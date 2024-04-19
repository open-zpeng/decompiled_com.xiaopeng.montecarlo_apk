package com.autonavi.gbl.card.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CustomUpdatePair implements Serializable {
    public String idStr;
    public String newStyle;
    public String newValue;

    public CustomUpdatePair() {
        this.idStr = "";
        this.newValue = "";
        this.newStyle = "";
    }

    public CustomUpdatePair(String str, String str2, String str3) {
        this.idStr = str;
        this.newValue = str2;
        this.newStyle = str3;
    }
}

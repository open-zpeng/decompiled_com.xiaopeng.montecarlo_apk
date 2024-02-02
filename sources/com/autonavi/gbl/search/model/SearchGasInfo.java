package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchGasInfo implements Serializable {
    public String price;
    public String type;
    public String unit;

    public SearchGasInfo() {
        this.type = "";
        this.price = "";
        this.unit = "";
    }

    public SearchGasInfo(String str, String str2, String str3) {
        this.type = str;
        this.price = str2;
        this.unit = str3;
    }
}

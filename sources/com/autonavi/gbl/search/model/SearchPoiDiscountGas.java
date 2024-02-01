package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiDiscountGas implements Serializable {
    public String discount;
    public String gasType;
    public String national;
    public String station;

    public SearchPoiDiscountGas() {
        this.national = "";
        this.station = "";
        this.discount = "";
        this.gasType = "";
    }

    public SearchPoiDiscountGas(String str, String str2, String str3, String str4) {
        this.national = str;
        this.station = str2;
        this.discount = str3;
        this.gasType = str4;
    }
}

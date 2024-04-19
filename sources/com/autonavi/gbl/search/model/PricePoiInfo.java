package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PricePoiInfo implements Serializable {
    public String price;
    public String type;

    public PricePoiInfo() {
        this.price = "";
        this.type = "";
    }

    public PricePoiInfo(String str, String str2) {
        this.price = str;
        this.type = str2;
    }
}

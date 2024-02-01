package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiHotelInfo implements Serializable {
    public String priceLowest;

    public SearchPoiHotelInfo() {
        this.priceLowest = "";
    }

    public SearchPoiHotelInfo(String str) {
        this.priceLowest = str;
    }
}

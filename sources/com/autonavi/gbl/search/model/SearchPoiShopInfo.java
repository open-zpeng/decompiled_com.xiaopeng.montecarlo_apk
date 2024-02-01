package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiShopInfo implements Serializable {
    public String name;
    public String poiId;

    public SearchPoiShopInfo() {
        this.poiId = "";
        this.name = "";
    }

    public SearchPoiShopInfo(String str, String str2) {
        this.poiId = str;
        this.name = str2;
    }
}

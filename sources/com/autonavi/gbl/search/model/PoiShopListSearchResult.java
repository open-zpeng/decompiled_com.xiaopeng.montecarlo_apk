package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PoiShopListSearchResult implements Serializable {
    public int count;
    public ArrayList<SearchCmallPoiInfo> shopList;

    public PoiShopListSearchResult() {
        this.count = 0;
        this.shopList = new ArrayList<>();
    }

    public PoiShopListSearchResult(int i, ArrayList<SearchCmallPoiInfo> arrayList) {
        this.count = i;
        this.shopList = arrayList;
    }
}

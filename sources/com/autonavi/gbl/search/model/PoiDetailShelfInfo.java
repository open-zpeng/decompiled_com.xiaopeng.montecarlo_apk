package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PoiDetailShelfInfo implements Serializable {
    public ArrayList<PoiDetailProductInfo> productInfoList;
    public SearchTabInfo tabInfo;

    public PoiDetailShelfInfo() {
        this.tabInfo = new SearchTabInfo();
        this.productInfoList = new ArrayList<>();
    }

    public PoiDetailShelfInfo(SearchTabInfo searchTabInfo, ArrayList<PoiDetailProductInfo> arrayList) {
        this.tabInfo = searchTabInfo;
        this.productInfoList = arrayList;
    }
}

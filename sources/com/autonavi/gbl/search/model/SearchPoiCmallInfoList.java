package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiCmallInfoList implements Serializable {
    public int count;
    public ArrayList<SearchCmallPoiInfo> poiCmallInfoList;

    public SearchPoiCmallInfoList() {
        this.count = -1;
        this.poiCmallInfoList = new ArrayList<>();
    }

    public SearchPoiCmallInfoList(int i, ArrayList<SearchCmallPoiInfo> arrayList) {
        this.count = i;
        this.poiCmallInfoList = arrayList;
    }
}

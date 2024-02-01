package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PoiDetailPoiInfo implements Serializable {
    public ArrayList<String> categoryList;
    public boolean isAvailable;
    public SearchBasicInfoBase poiInfoBase;

    public PoiDetailPoiInfo() {
        this.isAvailable = false;
        this.poiInfoBase = new SearchBasicInfoBase();
        this.categoryList = new ArrayList<>();
    }

    public PoiDetailPoiInfo(boolean z, SearchBasicInfoBase searchBasicInfoBase, ArrayList<String> arrayList) {
        this.isAvailable = z;
        this.poiInfoBase = searchBasicInfoBase;
        this.categoryList = arrayList;
    }
}

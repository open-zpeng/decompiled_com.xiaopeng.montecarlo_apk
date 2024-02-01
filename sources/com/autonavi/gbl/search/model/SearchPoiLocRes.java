package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiLocRes implements Serializable {
    public ArrayList<SearchDistrict> citylist;
    public int loctype;
    public int total;

    public SearchPoiLocRes() {
        this.loctype = 0;
        this.total = 0;
        this.citylist = new ArrayList<>();
    }

    public SearchPoiLocRes(int i, int i2, ArrayList<SearchDistrict> arrayList) {
        this.loctype = i;
        this.total = i2;
        this.citylist = arrayList;
    }
}

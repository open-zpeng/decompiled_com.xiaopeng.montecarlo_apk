package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiGasInfo implements Serializable {
    public SearchPoiDiscount discountInfo;
    public ArrayList<String> priceList;
    public ArrayList<String> typeList;

    public SearchPoiGasInfo() {
        this.typeList = new ArrayList<>();
        this.priceList = new ArrayList<>();
        this.discountInfo = new SearchPoiDiscount();
    }

    public SearchPoiGasInfo(ArrayList<String> arrayList, ArrayList<String> arrayList2, SearchPoiDiscount searchPoiDiscount) {
        this.typeList = arrayList;
        this.priceList = arrayList2;
        this.discountInfo = searchPoiDiscount;
    }
}

package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPackageItem implements Serializable {
    public String name;
    public ArrayList<SearchProductItem> productList;
    public String selectOption;

    public SearchPackageItem() {
        this.selectOption = "";
        this.name = "";
        this.productList = new ArrayList<>();
    }

    public SearchPackageItem(String str, String str2, ArrayList<SearchProductItem> arrayList) {
        this.selectOption = str;
        this.name = str2;
        this.productList = arrayList;
    }
}

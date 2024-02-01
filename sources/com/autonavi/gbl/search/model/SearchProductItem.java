package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchProductItem implements Serializable {
    public String name;
    public int num;
    public double price;
    public String unit;

    public SearchProductItem() {
        this.num = -1;
        this.price = 0.0d;
        this.unit = "";
        this.name = "";
    }

    public SearchProductItem(int i, double d, String str, String str2) {
        this.num = i;
        this.price = d;
        this.unit = str;
        this.name = str2;
    }
}

package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiDiscount implements Serializable {
    public String couponInfo;
    public String discount;
    public String discountMark;
    public ArrayList<SearchPoiDiscountGas> gasPrices;
    public String original;
    public String product;
    public String srcType;

    public SearchPoiDiscount() {
        this.original = "";
        this.discount = "";
        this.discountMark = "";
        this.couponInfo = "";
        this.product = "";
        this.srcType = "";
        this.gasPrices = new ArrayList<>();
    }

    public SearchPoiDiscount(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<SearchPoiDiscountGas> arrayList) {
        this.original = str;
        this.discount = str2;
        this.discountMark = str3;
        this.couponInfo = str4;
        this.product = str5;
        this.srcType = str6;
        this.gasPrices = arrayList;
    }
}

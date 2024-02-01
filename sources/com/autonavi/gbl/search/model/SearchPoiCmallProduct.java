package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiCmallProduct extends SearchProductInfoBase implements Serializable {
    public int sales = -1;
    public double couponPrice = 0.0d;
    public String skuName = "";
    public String desc = "";
    public PackageDetail packageInfo = new PackageDetail();
    public PurchaseNotes purchase = new PurchaseNotes();
    public SearchMediaInfo media = new SearchMediaInfo();
}

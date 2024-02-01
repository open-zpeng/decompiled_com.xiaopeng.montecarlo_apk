package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PackageDetail implements Serializable {
    public ArrayList<SearchPackageItem> packageList;
    public double totalPrice;

    public PackageDetail() {
        this.totalPrice = 0.0d;
        this.packageList = new ArrayList<>();
    }

    public PackageDetail(double d, ArrayList<SearchPackageItem> arrayList) {
        this.totalPrice = d;
        this.packageList = arrayList;
    }
}

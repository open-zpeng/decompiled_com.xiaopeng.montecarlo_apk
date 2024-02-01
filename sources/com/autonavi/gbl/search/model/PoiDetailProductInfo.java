package com.autonavi.gbl.search.model;

import com.autonavi.gbl.search.model.ShelfSourceType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PoiDetailProductInfo extends SearchProductInfoBase implements Serializable {
    public int sales = -1;
    public double couponPrice = 0.0d;
    @ShelfSourceType.ShelfSourceType1
    public int shelfSource = -1;
    public String activityTag = "";
    public SearchMediaInfo mediaInfo = new SearchMediaInfo();
    public ArrayList<SearchPackageItem> packageList = new ArrayList<>();
}

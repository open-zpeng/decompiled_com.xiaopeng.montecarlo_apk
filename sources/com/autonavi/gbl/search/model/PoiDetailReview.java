package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PoiDetailReview implements Serializable {
    public ArrayList<SearchReview> reviewList;
    public String star;
    public int total;

    public PoiDetailReview() {
        this.total = 0;
        this.star = "";
        this.reviewList = new ArrayList<>();
    }

    public PoiDetailReview(int i, String str, ArrayList<SearchReview> arrayList) {
        this.total = i;
        this.star = str;
        this.reviewList = arrayList;
    }
}

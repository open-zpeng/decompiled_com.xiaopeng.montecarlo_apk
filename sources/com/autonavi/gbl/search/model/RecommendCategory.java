package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RecommendCategory implements Serializable {
    public String category;
    public ArrayList<RecommendPoi> pois;

    public RecommendCategory() {
        this.category = "";
        this.pois = new ArrayList<>();
    }

    public RecommendCategory(String str, ArrayList<RecommendPoi> arrayList) {
        this.category = str;
        this.pois = arrayList;
    }
}

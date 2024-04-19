package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchAroundRecommendResult implements Serializable {
    public ArrayList<RecommendCategory> categories;
    public int code;
    public String message;
    public String result;
    public String timestamp;
    public String version;

    public SearchAroundRecommendResult() {
        this.code = -1;
        this.result = "";
        this.message = "";
        this.version = "";
        this.timestamp = "";
        this.categories = new ArrayList<>();
    }

    public SearchAroundRecommendResult(int i, String str, String str2, String str3, String str4, ArrayList<RecommendCategory> arrayList) {
        this.code = i;
        this.result = str;
        this.message = str2;
        this.version = str3;
        this.timestamp = str4;
        this.categories = arrayList;
    }
}

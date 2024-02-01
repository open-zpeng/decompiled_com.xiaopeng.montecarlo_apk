package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchSuggestResult implements Serializable {
    public int code;
    public int iPoiType;
    public int is_general_search;
    public String message;
    public String result;
    public String timestamp;
    public ArrayList<SearchSuggestTip> tipList;
    public int total;
    public String version;

    public SearchSuggestResult() {
        this.iPoiType = 0;
        this.code = -1;
        this.total = 0;
        this.is_general_search = -1;
        this.message = "";
        this.result = "";
        this.version = "";
        this.timestamp = "";
        this.tipList = new ArrayList<>();
    }

    public SearchSuggestResult(int i, int i2, int i3, int i4, String str, String str2, String str3, String str4, ArrayList<SearchSuggestTip> arrayList) {
        this.iPoiType = i;
        this.code = i2;
        this.total = i3;
        this.is_general_search = i4;
        this.message = str;
        this.result = str2;
        this.version = str3;
        this.timestamp = str4;
        this.tipList = arrayList;
    }
}

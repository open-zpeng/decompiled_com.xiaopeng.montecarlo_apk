package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchKeywordResult implements Serializable {
    public ArrayList<SearchPoiClassify> classify;
    public int code;
    public int iPoiType;
    public int isGeneralSaearch;
    public String keyword;
    public SearchLQii lqii;
    public String message;
    public ArrayList<SearchPoi> poiList;
    public SearchPoiLocRes poiLocres;
    public String result;
    public SearchPoiSuggestion suggestion;
    public String timestamp;
    public int total;
    public String version;

    public SearchKeywordResult() {
        this.iPoiType = 0;
        this.code = -1;
        this.total = 0;
        this.message = "";
        this.result = "";
        this.version = "";
        this.timestamp = "";
        this.isGeneralSaearch = 0;
        this.keyword = "";
        this.lqii = new SearchLQii();
        this.poiList = new ArrayList<>();
        this.poiLocres = new SearchPoiLocRes();
        this.suggestion = new SearchPoiSuggestion();
        this.classify = new ArrayList<>();
    }

    public SearchKeywordResult(int i, int i2, int i3, String str, String str2, String str3, String str4, int i4, String str5, SearchLQii searchLQii, ArrayList<SearchPoi> arrayList, SearchPoiLocRes searchPoiLocRes, SearchPoiSuggestion searchPoiSuggestion, ArrayList<SearchPoiClassify> arrayList2) {
        this.iPoiType = i;
        this.code = i2;
        this.total = i3;
        this.message = str;
        this.result = str2;
        this.version = str3;
        this.timestamp = str4;
        this.isGeneralSaearch = i4;
        this.keyword = str5;
        this.lqii = searchLQii;
        this.poiList = arrayList;
        this.poiLocres = searchPoiLocRes;
        this.suggestion = searchPoiSuggestion;
        this.classify = arrayList2;
    }
}

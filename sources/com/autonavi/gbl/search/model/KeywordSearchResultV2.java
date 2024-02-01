package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class KeywordSearchResultV2 implements Serializable {
    public SearchClassifyInfo classify;
    public int code;
    public String keyword;
    public SearchLqiiInfo lqii;
    public String message;
    public ArrayList<SearchPoiInfo> poiList;
    public SearchPoiLocRes poiLocres;
    public SearchPoiSuggestion poiSuggestion;
    public int poiType;
    public SearchRetainParam retainParam;
    public int total;

    public KeywordSearchResultV2() {
        this.poiType = 0;
        this.code = 0;
        this.total = 0;
        this.message = "";
        this.keyword = "";
        this.lqii = new SearchLqiiInfo();
        this.classify = new SearchClassifyInfo();
        this.poiLocres = new SearchPoiLocRes();
        this.poiSuggestion = new SearchPoiSuggestion();
        this.poiList = new ArrayList<>();
        this.retainParam = new SearchRetainParam();
    }

    public KeywordSearchResultV2(int i, int i2, int i3, String str, String str2, SearchLqiiInfo searchLqiiInfo, SearchClassifyInfo searchClassifyInfo, SearchPoiLocRes searchPoiLocRes, SearchPoiSuggestion searchPoiSuggestion, ArrayList<SearchPoiInfo> arrayList, SearchRetainParam searchRetainParam) {
        this.poiType = i;
        this.code = i2;
        this.total = i3;
        this.message = str;
        this.keyword = str2;
        this.lqii = searchLqiiInfo;
        this.classify = searchClassifyInfo;
        this.poiLocres = searchPoiLocRes;
        this.poiSuggestion = searchPoiSuggestion;
        this.poiList = arrayList;
        this.retainParam = searchRetainParam;
    }
}

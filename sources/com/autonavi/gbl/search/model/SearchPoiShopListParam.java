package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiShopListParam implements Serializable {
    public SearchPageParam page;
    public SearchPoiCmallDetailParam poiInfo;

    public SearchPoiShopListParam() {
        this.poiInfo = new SearchPoiCmallDetailParam();
        this.page = new SearchPageParam();
    }

    public SearchPoiShopListParam(SearchPoiCmallDetailParam searchPoiCmallDetailParam, SearchPageParam searchPageParam) {
        this.poiInfo = searchPoiCmallDetailParam;
        this.page = searchPageParam;
    }
}

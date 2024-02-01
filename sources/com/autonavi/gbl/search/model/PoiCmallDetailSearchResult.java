package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PoiCmallDetailSearchResult implements Serializable {
    public SearchPoiCmallInfoList poiList;
    public SearchPoiCmallProduct product;
    public SearchPoiShopInfo shop;

    public PoiCmallDetailSearchResult() {
        this.product = new SearchPoiCmallProduct();
        this.shop = new SearchPoiShopInfo();
        this.poiList = new SearchPoiCmallInfoList();
    }

    public PoiCmallDetailSearchResult(SearchPoiCmallProduct searchPoiCmallProduct, SearchPoiShopInfo searchPoiShopInfo, SearchPoiCmallInfoList searchPoiCmallInfoList) {
        this.product = searchPoiCmallProduct;
        this.shop = searchPoiShopInfo;
        this.poiList = searchPoiCmallInfoList;
    }
}

package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PoiDetailSearchResult implements Serializable {
    public PoiDetailBasicInfo baseInfo;
    public int code;
    public PoiDetailEvaluate evaluate;
    public ArrayList<PoiDetailShelfInfo> groupBuyInfoList;
    public String message;
    public PoiDetailReview review;
    public ArrayList<PoiDetailShelfInfo> voucherList;

    public PoiDetailSearchResult() {
        this.code = 0;
        this.message = "";
        this.baseInfo = new PoiDetailBasicInfo();
        this.evaluate = new PoiDetailEvaluate();
        this.review = new PoiDetailReview();
        this.groupBuyInfoList = new ArrayList<>();
        this.voucherList = new ArrayList<>();
    }

    public PoiDetailSearchResult(int i, String str, PoiDetailBasicInfo poiDetailBasicInfo, PoiDetailEvaluate poiDetailEvaluate, PoiDetailReview poiDetailReview, ArrayList<PoiDetailShelfInfo> arrayList, ArrayList<PoiDetailShelfInfo> arrayList2) {
        this.code = i;
        this.message = str;
        this.baseInfo = poiDetailBasicInfo;
        this.evaluate = poiDetailEvaluate;
        this.review = poiDetailReview;
        this.groupBuyInfoList = arrayList;
        this.voucherList = arrayList2;
    }
}

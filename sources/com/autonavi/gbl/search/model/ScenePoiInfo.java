package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ScenePoiInfo implements Serializable {
    public ScenePoiBasicInfo basicInfo;
    public SearchDynamicInfo dynamicInfo;
    public String itemType;
    public ArrayList<SceneProductInfo> productInfoList;
    public ScenePoiRankInfo rankInfo;

    public ScenePoiInfo() {
        this.itemType = "";
        this.basicInfo = new ScenePoiBasicInfo();
        this.rankInfo = new ScenePoiRankInfo();
        this.dynamicInfo = new SearchDynamicInfo();
        this.productInfoList = new ArrayList<>();
    }

    public ScenePoiInfo(String str, ScenePoiBasicInfo scenePoiBasicInfo, ScenePoiRankInfo scenePoiRankInfo, SearchDynamicInfo searchDynamicInfo, ArrayList<SceneProductInfo> arrayList) {
        this.itemType = str;
        this.basicInfo = scenePoiBasicInfo;
        this.rankInfo = scenePoiRankInfo;
        this.dynamicInfo = searchDynamicInfo;
        this.productInfoList = arrayList;
    }
}

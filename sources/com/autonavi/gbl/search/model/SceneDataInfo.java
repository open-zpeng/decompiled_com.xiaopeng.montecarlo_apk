package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SceneDataInfo implements Serializable {
    public SearchClassifyInfo classifyInfo;
    public SceneLqiiInfo lqiiInfo;
    public ArrayList<ScenePoiInfo> poiList;
    public int total;

    public SceneDataInfo() {
        this.total = 0;
        this.lqiiInfo = new SceneLqiiInfo();
        this.classifyInfo = new SearchClassifyInfo();
        this.poiList = new ArrayList<>();
    }

    public SceneDataInfo(int i, SceneLqiiInfo sceneLqiiInfo, SearchClassifyInfo searchClassifyInfo, ArrayList<ScenePoiInfo> arrayList) {
        this.total = i;
        this.lqiiInfo = sceneLqiiInfo;
        this.classifyInfo = searchClassifyInfo;
        this.poiList = arrayList;
    }
}

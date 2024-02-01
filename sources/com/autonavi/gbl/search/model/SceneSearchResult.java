package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SceneSearchResult implements Serializable {
    public int code;
    public ArrayList<SceneDataInfo> dataList;
    public String message;
    public int poiType;

    public SceneSearchResult() {
        this.poiType = 0;
        this.code = 0;
        this.message = "";
        this.dataList = new ArrayList<>();
    }

    public SceneSearchResult(int i, int i2, String str, ArrayList<SceneDataInfo> arrayList) {
        this.poiType = i;
        this.code = i2;
        this.message = str;
        this.dataList = arrayList;
    }
}

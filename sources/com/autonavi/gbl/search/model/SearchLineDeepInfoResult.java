package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchLineDeepInfoResult implements Serializable {
    public int code;
    public ArrayList<LinePoiBase> data;
    public int iPoiType;
    public String message;

    public SearchLineDeepInfoResult() {
        this.iPoiType = 0;
        this.code = -1;
        this.message = "";
        this.data = new ArrayList<>();
    }

    public SearchLineDeepInfoResult(int i, int i2, String str, ArrayList<LinePoiBase> arrayList) {
        this.iPoiType = i;
        this.code = i2;
        this.message = str;
        this.data = arrayList;
    }
}

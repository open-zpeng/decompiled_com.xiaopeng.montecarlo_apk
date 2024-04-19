package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchDetailInfoResult implements Serializable {
    public int code;
    public int iPoiType;
    public String message;
    public ArrayList<DetailPoi> pois;
    public String result;
    public String timestamp;
    public int total;
    public String version;

    public SearchDetailInfoResult() {
        this.iPoiType = 0;
        this.code = -1;
        this.total = 0;
        this.result = "";
        this.message = "";
        this.version = "";
        this.timestamp = "";
        this.pois = new ArrayList<>();
    }

    public SearchDetailInfoResult(int i, int i2, int i3, String str, String str2, String str3, String str4, ArrayList<DetailPoi> arrayList) {
        this.iPoiType = i;
        this.code = i2;
        this.total = i3;
        this.result = str;
        this.message = str2;
        this.version = str3;
        this.timestamp = str4;
        this.pois = arrayList;
    }
}

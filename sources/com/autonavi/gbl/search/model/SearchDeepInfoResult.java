package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchDeepInfoResult implements Serializable {
    public int code;
    public DeepinfoPoi deepinfoPoi;
    public int iPoiType;
    public String message;
    public String result;
    public String timestamp;
    public String version;

    public SearchDeepInfoResult() {
        this.iPoiType = 0;
        this.code = -1;
        this.result = "";
        this.message = "";
        this.version = "";
        this.timestamp = "";
        this.deepinfoPoi = new DeepinfoPoi();
    }

    public SearchDeepInfoResult(int i, int i2, String str, String str2, String str3, String str4, DeepinfoPoi deepinfoPoi) {
        this.iPoiType = i;
        this.code = i2;
        this.result = str;
        this.message = str2;
        this.version = str3;
        this.timestamp = str4;
        this.deepinfoPoi = deepinfoPoi;
    }
}

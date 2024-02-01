package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchChargingLiveStatusResult implements Serializable {
    public int code;
    public int fast_free;
    public int fast_total;
    public String message;
    public String result;
    public int slow_free;
    public int slow_total;
    public String timestamp;
    public int total;
    public String version;

    public SearchChargingLiveStatusResult() {
        this.code = -1;
        this.result = "";
        this.message = "";
        this.version = "";
        this.timestamp = "";
        this.total = 0;
        this.fast_total = 0;
        this.fast_free = 0;
        this.slow_total = 0;
        this.slow_free = 0;
    }

    public SearchChargingLiveStatusResult(int i, String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, int i6) {
        this.code = i;
        this.result = str;
        this.message = str2;
        this.version = str3;
        this.timestamp = str4;
        this.total = i2;
        this.fast_total = i3;
        this.fast_free = i4;
        this.slow_total = i5;
        this.slow_free = i6;
    }
}

package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchAlongWayResult implements Serializable {
    public int code;
    public int distance;
    public int iPoiType;
    public String message;
    public ArrayList<AlongWayPoi> pois;
    public String result;
    public String timestamp;
    public int toll;
    public int total;
    public int travel_time;
    public String version;

    public SearchAlongWayResult() {
        this.iPoiType = 0;
        this.code = -1;
        this.distance = 0;
        this.travel_time = 0;
        this.toll = 0;
        this.total = 0;
        this.result = "";
        this.message = "";
        this.version = "";
        this.timestamp = "";
        this.pois = new ArrayList<>();
    }

    public SearchAlongWayResult(int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, String str3, String str4, ArrayList<AlongWayPoi> arrayList) {
        this.iPoiType = i;
        this.code = i2;
        this.distance = i3;
        this.travel_time = i4;
        this.toll = i5;
        this.total = i6;
        this.result = str;
        this.message = str2;
        this.version = str3;
        this.timestamp = str4;
        this.pois = arrayList;
    }
}

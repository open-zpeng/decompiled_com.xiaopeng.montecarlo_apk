package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapRoadTip implements Serializable {
    public int color;
    public double lat;
    public double lon;
    public String name;
    public long poiid;
    public int rank;
    public int type;
    public double z;

    public MapRoadTip() {
        this.name = "";
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.z = 0.0d;
        this.color = 0;
        this.type = 0;
        this.rank = 0;
        this.poiid = 0L;
    }

    public MapRoadTip(String str, double d, double d2, double d3, int i, int i2, int i3, long j) {
        this.name = str;
        this.lon = d;
        this.lat = d2;
        this.z = d3;
        this.color = i;
        this.type = i2;
        this.rank = i3;
        this.poiid = j;
    }
}

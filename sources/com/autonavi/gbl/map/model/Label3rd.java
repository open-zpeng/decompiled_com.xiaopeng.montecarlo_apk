package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Label3rd implements Serializable {
    public int anchor;
    public int bFouces;
    public double lat;
    public double lon;
    public int mainkey;
    public int maxzoom;
    public int minzoom;
    public String name;
    public String poiId;
    public float rank;
    public int subkey;
    public int type;

    public Label3rd() {
        this.name = "";
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.poiId = "";
        this.anchor = 0;
        this.mainkey = 0;
        this.subkey = 0;
        this.minzoom = 0;
        this.maxzoom = 0;
        this.rank = 0.0f;
        this.type = 0;
        this.bFouces = 0;
    }

    public Label3rd(String str, double d, double d2, String str2, int i, int i2, int i3, int i4, int i5, float f, int i6, int i7) {
        this.name = str;
        this.lon = d;
        this.lat = d2;
        this.poiId = str2;
        this.anchor = i;
        this.mainkey = i2;
        this.subkey = i3;
        this.minzoom = i4;
        this.maxzoom = i5;
        this.rank = f;
        this.type = i6;
        this.bFouces = i7;
    }
}

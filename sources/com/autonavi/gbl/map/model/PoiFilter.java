package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PoiFilter implements Serializable {
    public int anchor;
    public int filterPoiType;
    public int group;
    public boolean isRect;
    public String keyName;
    public double[] mapPoints;
    public float maxLevel;
    public float minLevel;
    public float screenHeight;
    public float screenWidth;
    public int type;
    public float xRatio;
    public float yRatio;

    public PoiFilter() {
        this.keyName = "";
        this.screenWidth = 0.0f;
        this.screenHeight = 0.0f;
        this.maxLevel = 0.0f;
        this.minLevel = 0.0f;
        this.group = 0;
        this.type = 0;
        this.filterPoiType = 0;
        this.anchor = 0;
        this.xRatio = 0.0f;
        this.yRatio = 0.0f;
        this.isRect = false;
        this.mapPoints = new double[8];
    }

    public PoiFilter(String str, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, float f5, float f6, double[] dArr, boolean z) {
        this.keyName = str;
        this.screenWidth = f;
        this.screenHeight = f2;
        this.maxLevel = f3;
        this.minLevel = f4;
        this.group = i;
        this.type = i2;
        this.filterPoiType = i3;
        this.anchor = i4;
        this.xRatio = f5;
        this.yRatio = f6;
        this.mapPoints = dArr;
        this.isRect = z;
    }
}

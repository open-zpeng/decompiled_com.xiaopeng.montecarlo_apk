package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CustomStyleParam implements Serializable {
    public int mainKey;
    public int maxZoom;
    public int minZoom;
    public int subKey;

    public CustomStyleParam() {
        this.mainKey = 0;
        this.subKey = 0;
        this.minZoom = 0;
        this.maxZoom = 20;
    }

    public CustomStyleParam(int i, int i2, int i3, int i4) {
        this.mainKey = i;
        this.subKey = i2;
        this.minZoom = i3;
        this.maxZoom = i4;
    }
}

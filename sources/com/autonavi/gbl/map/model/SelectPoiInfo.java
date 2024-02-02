package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SelectPoiInfo implements Serializable {
    public int radius;
    public int winx;
    public int winy;

    public SelectPoiInfo() {
        this.winx = 0;
        this.winy = 0;
        this.radius = 0;
    }

    public SelectPoiInfo(int i, int i2, int i3) {
        this.winx = i;
        this.winy = i2;
        this.radius = i3;
    }
}

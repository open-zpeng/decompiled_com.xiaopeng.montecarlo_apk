package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AdMapPoint implements Serializable {
    public int nLat;
    public int nLon;
    public int nZlevel;

    public AdMapPoint() {
        this.nLon = 0;
        this.nLat = 0;
        this.nZlevel = 0;
    }

    public AdMapPoint(int i, int i2, int i3) {
        this.nLon = i;
        this.nLat = i2;
        this.nZlevel = i3;
    }
}

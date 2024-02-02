package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DeepinfoPoiParkinfo implements Serializable {
    public int freeSpace;
    public int parkColor;
    public int sumSpace;

    public DeepinfoPoiParkinfo() {
        this.sumSpace = -1;
        this.freeSpace = -1;
        this.parkColor = -1;
    }

    public DeepinfoPoiParkinfo(int i, int i2, int i3) {
        this.sumSpace = i;
        this.freeSpace = i2;
        this.parkColor = i3;
    }
}

package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DeepinfoPoiParkinfo implements Serializable {
    public int freeSpace;
    public int parkColor;
    public String srcType;
    public int sumSpace;

    public DeepinfoPoiParkinfo() {
        this.sumSpace = -1;
        this.freeSpace = -1;
        this.parkColor = -1;
        this.srcType = "";
    }

    public DeepinfoPoiParkinfo(int i, int i2, int i3, String str) {
        this.sumSpace = i;
        this.freeSpace = i2;
        this.parkColor = i3;
        this.srcType = str;
    }
}

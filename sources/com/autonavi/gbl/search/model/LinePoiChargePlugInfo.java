package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LinePoiChargePlugInfo implements Serializable {
    public int maxPower;
    public int minPower;

    public LinePoiChargePlugInfo() {
        this.maxPower = 0;
        this.minPower = 0;
    }

    public LinePoiChargePlugInfo(int i, int i2) {
        this.maxPower = i;
        this.minPower = i2;
    }
}

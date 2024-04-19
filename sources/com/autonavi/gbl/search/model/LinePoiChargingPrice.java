package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LinePoiChargingPrice implements Serializable {
    public float fMax;
    public float fMin;

    public LinePoiChargingPrice() {
        this.fMax = 0.0f;
        this.fMin = 0.0f;
    }

    public LinePoiChargingPrice(float f, float f2) {
        this.fMax = f;
        this.fMin = f2;
    }
}

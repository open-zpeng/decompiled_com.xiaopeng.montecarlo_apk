package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GetOpenlayerParam implements Serializable {
    public float alpha;
    public int poiCount;
    public int poiMaxzoom;
    public int poiMinzoom;

    public GetOpenlayerParam() {
        this.poiMinzoom = 0;
        this.poiMaxzoom = 0;
        this.alpha = 1.0f;
        this.poiCount = 0;
    }

    public GetOpenlayerParam(int i, int i2, float f, int i3) {
        this.poiMinzoom = i;
        this.poiMaxzoom = i2;
        this.alpha = f;
        this.poiCount = i3;
    }
}

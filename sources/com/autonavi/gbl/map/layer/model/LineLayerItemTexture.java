package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LineLayerItemTexture implements Serializable {
    public long color;
    public int markerId;
    public int width;

    public LineLayerItemTexture() {
        this.markerId = -1;
        this.color = -1L;
        this.width = 10;
    }

    public LineLayerItemTexture(int i, long j, int i2) {
        this.markerId = i;
        this.color = j;
        this.width = i2;
    }
}

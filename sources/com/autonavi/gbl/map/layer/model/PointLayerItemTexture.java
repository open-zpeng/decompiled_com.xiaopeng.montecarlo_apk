package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PointLayerItemTexture implements Serializable {
    public float scale;
    public float x1;
    public float x2;
    public float y1;
    public float y2;

    public PointLayerItemTexture() {
        this.x1 = 0.0f;
        this.y1 = 0.0f;
        this.x2 = 1.0f;
        this.y2 = 1.0f;
        this.scale = 1.0f;
    }

    public PointLayerItemTexture(float f, float f2, float f3, float f4, float f5) {
        this.x1 = f;
        this.y1 = f2;
        this.x2 = f3;
        this.y2 = f4;
        this.scale = f5;
    }
}

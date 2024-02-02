package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PolylineCapTextureInfo implements Serializable {
    public float x1;
    public float x2;
    public float y1;
    public float y2;

    public PolylineCapTextureInfo() {
        this.x1 = 0.0f;
        this.y1 = 0.0f;
        this.x2 = 0.0f;
        this.y2 = 0.0f;
    }

    public PolylineCapTextureInfo(float f, float f2, float f3, float f4) {
        this.x1 = f;
        this.y1 = f2;
        this.x2 = f3;
        this.y2 = f4;
    }
}

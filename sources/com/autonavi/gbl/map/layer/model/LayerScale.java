package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LayerScale implements Serializable {
    public double maxScale;
    public double minScale;

    public LayerScale() {
        this.minScale = 3.0d;
        this.maxScale = 22.0d;
    }

    public LayerScale(double d, double d2) {
        this.minScale = d;
        this.maxScale = d2;
    }
}

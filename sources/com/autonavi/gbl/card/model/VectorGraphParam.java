package com.autonavi.gbl.card.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class VectorGraphParam implements Serializable {
    public boolean isNight;
    public float scaleFactor;

    public VectorGraphParam() {
        this.isNight = false;
        this.scaleFactor = 1.0f;
    }

    public VectorGraphParam(boolean z, float f) {
        this.isNight = z;
        this.scaleFactor = f;
    }
}

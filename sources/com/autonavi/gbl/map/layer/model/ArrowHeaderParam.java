package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ArrowHeaderParam implements Serializable {
    public int headerAngle;
    public float headerWidthRate;

    public ArrowHeaderParam() {
        this.headerAngle = 0;
        this.headerWidthRate = 1.0f;
    }

    public ArrowHeaderParam(int i, float f) {
        this.headerAngle = i;
        this.headerWidthRate = f;
    }
}

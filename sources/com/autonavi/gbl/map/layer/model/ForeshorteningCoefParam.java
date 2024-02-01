package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ForeshorteningCoefParam implements Serializable {
    public float displayMaxScale;
    public float displayMaxScaleDistance;
    public float displayMinScale;
    public float displayMinScaleDistance;

    public ForeshorteningCoefParam() {
        this.displayMaxScaleDistance = 10.0f;
        this.displayMaxScale = 0.5f;
        this.displayMinScaleDistance = 500.0f;
        this.displayMinScale = 0.3f;
    }

    public ForeshorteningCoefParam(float f, float f2, float f3, float f4) {
        this.displayMaxScaleDistance = f;
        this.displayMaxScale = f2;
        this.displayMinScaleDistance = f3;
        this.displayMinScale = f4;
    }
}

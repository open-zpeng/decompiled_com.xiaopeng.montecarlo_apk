package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MapColorParam implements Serializable {
    public float fAlpha;
    public float fBlue;
    public float fGreen;
    public float fRed;

    public MapColorParam() {
        this.fRed = 0.0f;
        this.fGreen = 0.0f;
        this.fBlue = 0.0f;
        this.fAlpha = 0.0f;
    }

    public MapColorParam(float f, float f2, float f3, float f4) {
        this.fRed = f;
        this.fGreen = f2;
        this.fBlue = f3;
        this.fAlpha = f4;
    }
}

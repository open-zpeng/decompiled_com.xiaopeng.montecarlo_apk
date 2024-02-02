package com.autonavi.gbl.map.model;
/* loaded from: classes.dex */
public class FontMetrics {
    public float fAscent;
    public float fDescent;
    public float fHeight;
    public float fLeading;

    public FontMetrics() {
        this.fAscent = 0.0f;
        this.fDescent = 0.0f;
        this.fLeading = 0.0f;
        this.fHeight = 0.0f;
    }

    public FontMetrics(float f, float f2, float f3, float f4) {
        this.fAscent = f;
        this.fDescent = f2;
        this.fLeading = f3;
        this.fHeight = f4;
    }
}

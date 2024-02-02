package com.autonavi.gbl.map.model;
/* loaded from: classes.dex */
public class GlyphMetrics {
    public float fAdvance;
    public float fLeft;
    public float fTop;
    public int nHeight;
    public int nWidth;

    public GlyphMetrics() {
        this.nWidth = 0;
        this.nHeight = 0;
        this.fLeft = 0.0f;
        this.fTop = 0.0f;
        this.fAdvance = 0.0f;
    }

    public GlyphMetrics(int i, int i2, float f, float f2, float f3) {
        this.nWidth = i;
        this.nHeight = i2;
        this.fLeft = f;
        this.fTop = f2;
        this.fAdvance = f3;
    }
}

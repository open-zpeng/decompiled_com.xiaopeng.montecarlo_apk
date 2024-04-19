package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GlyphRequestParam implements Serializable {
    public int drawingMode;
    public GlyphMetrics fGlyphMetrics;
    public Font font;
    public int isEmoji;
    public int isSDF;
    public String languageArr;
    public float strokeWidth;
    public short[] u16Str;

    public GlyphRequestParam() {
        this.font = new Font();
        this.drawingMode = 0;
        this.strokeWidth = 0.0f;
        this.fGlyphMetrics = new GlyphMetrics();
        this.languageArr = "";
        this.isEmoji = 0;
        this.isSDF = 0;
    }

    public GlyphRequestParam(short[] sArr, Font font, int i, float f, GlyphMetrics glyphMetrics, String str, int i2, int i3) {
        this.u16Str = sArr;
        this.font = font;
        this.drawingMode = i;
        this.strokeWidth = f;
        this.fGlyphMetrics = glyphMetrics;
        this.languageArr = str;
        this.isEmoji = i2;
        this.isSDF = i3;
    }
}

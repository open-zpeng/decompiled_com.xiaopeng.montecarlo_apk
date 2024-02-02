package com.autonavi.gbl.map.model;
/* loaded from: classes.dex */
public class GlyphRaster {
    public byte[] bitmapBuffer;
    public int bitmapHeight;
    public int bitmapPixelMode;
    public int bitmapSize;
    public int bitmapWidth;

    public GlyphRaster() {
        this.bitmapSize = 0;
        this.bitmapWidth = 0;
        this.bitmapHeight = 0;
        this.bitmapPixelMode = 0;
    }

    public GlyphRaster(byte[] bArr, int i, int i2, int i3, int i4) {
        this.bitmapBuffer = bArr;
        this.bitmapSize = i;
        this.bitmapWidth = i2;
        this.bitmapHeight = i3;
        this.bitmapPixelMode = i4;
    }
}

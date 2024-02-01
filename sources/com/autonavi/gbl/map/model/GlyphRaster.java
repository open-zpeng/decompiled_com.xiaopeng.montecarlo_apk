package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GlyphRaster implements Serializable {
    public byte[] bitmapBuffer;
    public int bitmapHeight;
    public int bitmapPixelMode;
    public int bitmapWidth;

    public GlyphRaster() {
        this.bitmapWidth = 0;
        this.bitmapHeight = 0;
        this.bitmapPixelMode = 0;
        this.bitmapBuffer = null;
    }

    public GlyphRaster(byte[] bArr, int i, int i2, int i3) {
        this.bitmapBuffer = bArr;
        this.bitmapWidth = i;
        this.bitmapHeight = i2;
        this.bitmapPixelMode = i3;
    }
}

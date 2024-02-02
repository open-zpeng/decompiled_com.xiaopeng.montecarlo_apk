package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TextBuffer implements Serializable {
    public byte[] buffer;
    public int height;
    public boolean isPreMulted;
    public int width;

    public TextBuffer() {
        this.width = 0;
        this.height = 0;
        this.isPreMulted = false;
        this.buffer = null;
    }

    public TextBuffer(byte[] bArr, int i, int i2, boolean z) {
        this.buffer = bArr;
        this.width = i;
        this.height = i2;
        this.isPreMulted = z;
    }
}

package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ScreenShotInfo implements Serializable {
    public byte[] buffer;
    public int format;
    public int height;
    public int index;
    public byte pixelByte;
    public int width;

    public ScreenShotInfo() {
        this.index = 0;
        this.format = 0;
        this.pixelByte = (byte) 0;
        this.width = 0;
        this.height = 0;
        this.buffer = null;
    }

    public ScreenShotInfo(int i, int i2, byte b, int i3, int i4, byte[] bArr) {
        this.index = i;
        this.format = i2;
        this.pixelByte = b;
        this.width = i3;
        this.height = i4;
        this.buffer = bArr;
    }
}

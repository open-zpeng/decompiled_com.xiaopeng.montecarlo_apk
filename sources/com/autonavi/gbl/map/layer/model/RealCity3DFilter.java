package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RealCity3DFilter implements Serializable {
    public boolean bCopy;
    public byte[] bufferDayLUT;
    public int bufferDayLUTLen;
    public byte[] bufferNightLUT;
    public int bufferNightLUTLen;
    public int colors;
    public int imageHeight;
    public int imageWidth;
    public boolean isOn;
    public int maxcolors;
    public MapRGBA skyfogColor;

    public RealCity3DFilter() {
        this.isOn = false;
        this.bufferDayLUTLen = 0;
        this.bufferNightLUTLen = 0;
        this.bCopy = false;
        this.colors = 16;
        this.maxcolors = 15;
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.skyfogColor = new MapRGBA();
        this.bufferDayLUT = null;
        this.bufferNightLUT = null;
    }

    public RealCity3DFilter(boolean z, byte[] bArr, int i, byte[] bArr2, int i2, boolean z2, int i3, int i4, int i5, int i6, MapRGBA mapRGBA) {
        this.isOn = z;
        this.bufferDayLUT = bArr;
        this.bufferDayLUTLen = i;
        this.bufferNightLUT = bArr2;
        this.bufferNightLUTLen = i2;
        this.bCopy = z2;
        this.colors = i3;
        this.maxcolors = i4;
        this.imageWidth = i5;
        this.imageHeight = i6;
        this.skyfogColor = mapRGBA;
    }
}

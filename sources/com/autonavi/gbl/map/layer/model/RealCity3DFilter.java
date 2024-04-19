package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RealCity3DFilter implements Serializable {
    public MapRGBA Skyfog_color;
    public boolean bCopy;
    public byte[] bufferDayLUT;
    public byte[] bufferNightLUT;
    public int colors;
    public int imageHeight;
    public int imageWidth;
    public boolean isOn;
    public int maxcolors;

    public RealCity3DFilter() {
        this.isOn = false;
        this.bCopy = false;
        this.colors = 16;
        this.maxcolors = 15;
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.Skyfog_color = new MapRGBA();
        this.bufferDayLUT = null;
        this.bufferNightLUT = null;
    }

    public RealCity3DFilter(boolean z, byte[] bArr, byte[] bArr2, boolean z2, int i, int i2, int i3, int i4, MapRGBA mapRGBA) {
        this.isOn = z;
        this.bufferDayLUT = bArr;
        this.bufferNightLUT = bArr2;
        this.bCopy = z2;
        this.colors = i;
        this.maxcolors = i2;
        this.imageWidth = i3;
        this.imageHeight = i4;
        this.Skyfog_color = mapRGBA;
    }
}

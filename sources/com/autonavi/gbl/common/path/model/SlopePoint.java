package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SlopePoint implements Serializable {
    public int angle;
    public short hight;
    public int lat;
    public int length;
    public int lon;

    public SlopePoint() {
        this.lon = 0;
        this.lat = 0;
        this.angle = 0;
        this.length = 0;
        this.hight = (short) 0;
    }

    public SlopePoint(int i, int i2, int i3, int i4, short s) {
        this.lon = i;
        this.lat = i2;
        this.angle = i3;
        this.length = i4;
        this.hight = s;
    }
}

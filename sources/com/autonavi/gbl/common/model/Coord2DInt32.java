package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Coord2DInt32 implements Serializable {
    public int lat;
    public int lon;

    public Coord2DInt32() {
        this.lon = 0;
        this.lat = 0;
    }

    public Coord2DInt32(int i, int i2) {
        this.lon = i;
        this.lat = i2;
    }
}

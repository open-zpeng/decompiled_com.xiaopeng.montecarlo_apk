package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Coord3DInt32 implements Serializable {
    public int lat;
    public int lon;
    public int z;

    public Coord3DInt32() {
        this.lon = 0;
        this.lat = 0;
        this.z = 0;
    }

    public Coord3DInt32(int i, int i2, int i3) {
        this.lon = i;
        this.lat = i2;
        this.z = i3;
    }
}

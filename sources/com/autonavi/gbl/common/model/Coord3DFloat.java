package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Coord3DFloat implements Serializable {
    public float lat;
    public float lon;
    public float z;

    public Coord3DFloat() {
        this.lon = 0.0f;
        this.lat = 0.0f;
        this.z = 0.0f;
    }

    public Coord3DFloat(float f, float f2, float f3) {
        this.lon = f;
        this.lat = f2;
        this.z = f3;
    }
}

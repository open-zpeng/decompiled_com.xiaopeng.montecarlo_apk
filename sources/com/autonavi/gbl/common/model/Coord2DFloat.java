package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Coord2DFloat implements Serializable {
    public float lat;
    public float lon;

    public Coord2DFloat() {
        this.lon = 0.0f;
        this.lat = 0.0f;
    }

    public Coord2DFloat(float f, float f2) {
        this.lon = f;
        this.lat = f2;
    }
}

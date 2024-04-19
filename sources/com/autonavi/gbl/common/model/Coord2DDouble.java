package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Coord2DDouble implements Serializable {
    public double lat;
    public double lon;

    public Coord2DDouble() {
        this.lon = 0.0d;
        this.lat = 0.0d;
    }

    public Coord2DDouble(double d, double d2) {
        this.lon = d;
        this.lat = d2;
    }
}

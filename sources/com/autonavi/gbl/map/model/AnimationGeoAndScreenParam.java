package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AnimationGeoAndScreenParam implements Serializable {
    public double lat;
    public double lon;
    public int toScreenX;
    public int toScreenY;
    public double z;

    public AnimationGeoAndScreenParam() {
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.z = 0.0d;
        this.toScreenX = 0;
        this.toScreenY = 0;
    }

    public AnimationGeoAndScreenParam(double d, double d2, double d3, int i, int i2) {
        this.lon = d;
        this.lat = d2;
        this.z = d3;
        this.toScreenX = i;
        this.toScreenY = i2;
    }
}

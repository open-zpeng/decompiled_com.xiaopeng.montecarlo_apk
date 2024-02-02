package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MapPositionParam implements Serializable {
    public double lat;
    public double lon;
    public float mapRollAngle;
    public float maplevel;
    public double z;

    public MapPositionParam() {
        this.lon = -9999.0d;
        this.lat = -9999.0d;
        this.z = 0.0d;
        this.mapRollAngle = -9999.0f;
        this.maplevel = -9999.0f;
    }

    public MapPositionParam(double d, double d2, double d3, float f, float f2) {
        this.lon = d;
        this.lat = d2;
        this.z = d3;
        this.mapRollAngle = f;
        this.maplevel = f2;
    }
}

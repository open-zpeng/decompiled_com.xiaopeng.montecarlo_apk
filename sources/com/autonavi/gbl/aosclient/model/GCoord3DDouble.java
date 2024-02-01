package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCoord3DDouble implements Serializable {
    public double lat;
    public double lon;
    public double z;

    public GCoord3DDouble() {
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.z = 0.0d;
    }

    public GCoord3DDouble(double d, double d2, double d3) {
        this.lon = d;
        this.lat = d2;
        this.z = d3;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCoord2DDouble implements Serializable {
    public double lat;
    public double lon;

    public GCoord2DDouble() {
        this.lon = 0.0d;
        this.lat = 0.0d;
    }

    public GCoord2DDouble(double d, double d2) {
        this.lon = d;
        this.lat = d2;
    }
}

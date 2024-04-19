package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRangeSpiderPoint implements Serializable {
    public double lat;
    public double lon;

    public GRangeSpiderPoint() {
        this.lon = 0.0d;
        this.lat = 0.0d;
    }

    public GRangeSpiderPoint(double d, double d2) {
        this.lon = d;
        this.lat = d2;
    }
}

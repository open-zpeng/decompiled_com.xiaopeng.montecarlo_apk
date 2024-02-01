package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQueryPersentWeatherReqItemPoint implements Serializable {
    public double lat;
    public double lon;

    public GQueryPersentWeatherReqItemPoint() {
        this.lon = 0.0d;
        this.lat = 0.0d;
    }

    public GQueryPersentWeatherReqItemPoint(double d, double d2) {
        this.lon = d;
        this.lat = d2;
    }
}

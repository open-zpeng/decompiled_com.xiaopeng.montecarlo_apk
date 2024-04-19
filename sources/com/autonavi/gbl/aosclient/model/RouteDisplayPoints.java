package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RouteDisplayPoints implements Serializable {
    public String lat;
    public String lon;

    public RouteDisplayPoints() {
        this.lon = "";
        this.lat = "";
    }

    public RouteDisplayPoints(String str, String str2) {
        this.lon = str;
        this.lat = str2;
    }
}

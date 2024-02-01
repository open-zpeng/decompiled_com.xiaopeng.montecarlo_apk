package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataMidpoi implements Serializable {
    public double lat;
    public double lon;
    public String name;
    public String poiid;

    public WsNavigationDynamicDataMidpoi() {
        this.poiid = "";
        this.name = "";
        this.lon = 0.0d;
        this.lat = 0.0d;
    }

    public WsNavigationDynamicDataMidpoi(String str, String str2, double d, double d2) {
        this.poiid = str;
        this.name = str2;
        this.lon = d;
        this.lat = d2;
    }
}

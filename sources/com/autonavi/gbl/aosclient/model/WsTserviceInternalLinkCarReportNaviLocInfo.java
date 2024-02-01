package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTserviceInternalLinkCarReportNaviLocInfo implements Serializable {
    public double lat;
    public double lon;

    public WsTserviceInternalLinkCarReportNaviLocInfo() {
        this.lat = 0.0d;
        this.lon = 0.0d;
    }

    public WsTserviceInternalLinkCarReportNaviLocInfo(double d, double d2) {
        this.lat = d;
        this.lon = d2;
    }
}

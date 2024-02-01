package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqStartPoints implements Serializable {
    public int idx;
    public double lat;
    public double lon;
    public int type;

    public GNavigationEtaqueryReqStartPoints() {
        this.idx = 0;
        this.type = 0;
        this.lon = 0.0d;
        this.lat = 0.0d;
    }

    public GNavigationEtaqueryReqStartPoints(int i, int i2, double d, double d2) {
        this.idx = i;
        this.type = i2;
        this.lon = d;
        this.lat = d2;
    }
}

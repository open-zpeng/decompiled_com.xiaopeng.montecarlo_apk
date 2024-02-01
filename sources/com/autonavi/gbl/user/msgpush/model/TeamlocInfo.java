package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TeamlocInfo implements Serializable {
    public double lat;
    public double lon;

    public TeamlocInfo() {
        this.lon = 0.0d;
        this.lat = 0.0d;
    }

    public TeamlocInfo(double d, double d2) {
        this.lon = d;
        this.lat = d2;
    }
}

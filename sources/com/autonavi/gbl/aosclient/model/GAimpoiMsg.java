package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GAimpoiMsg implements Serializable {
    public String address;
    public double lat;
    public double lon;
    public String name;

    public GAimpoiMsg() {
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.name = "";
        this.address = "";
    }

    public GAimpoiMsg(double d, double d2, String str, String str2) {
        this.lon = d;
        this.lat = d2;
        this.name = str;
        this.address = str2;
    }
}

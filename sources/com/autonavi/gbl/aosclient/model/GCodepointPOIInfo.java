package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCodepointPOIInfo implements Serializable {
    public String brand_icon;
    public String id;
    public double latitude;
    public double longitude;
    public String name;

    public GCodepointPOIInfo() {
        this.id = "";
        this.name = "";
        this.brand_icon = "";
        this.longitude = 0.0d;
        this.latitude = 0.0d;
    }

    public GCodepointPOIInfo(String str, String str2, String str3, double d, double d2) {
        this.id = str;
        this.name = str2;
        this.brand_icon = str3;
        this.longitude = d;
        this.latitude = d2;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GPredictInfo implements Serializable {
    public String label;
    public String poi_address;
    public String poi_id;
    public String poi_name;
    public double poi_x;
    public double poi_y;
    public double x;
    public double y;

    public GPredictInfo() {
        this.label = "";
        this.poi_id = "";
        this.poi_name = "";
        this.poi_address = "";
        this.x = 0.0d;
        this.y = 0.0d;
        this.poi_x = 0.0d;
        this.poi_y = 0.0d;
    }

    public GPredictInfo(String str, String str2, String str3, String str4, double d, double d2, double d3, double d4) {
        this.label = str;
        this.poi_id = str2;
        this.poi_name = str3;
        this.poi_address = str4;
        this.x = d;
        this.y = d2;
        this.poi_x = d3;
        this.poi_y = d4;
    }
}

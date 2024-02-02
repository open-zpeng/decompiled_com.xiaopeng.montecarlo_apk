package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RoutepathrestorationVehicleInfo implements Serializable {
    public String axis;
    public String height;
    public String load;
    public String plate;
    public String size;
    public String type;
    public String weight;
    public String width;

    public RoutepathrestorationVehicleInfo() {
        this.type = "";
        this.size = "";
        this.height = "";
        this.load = "";
        this.width = "";
        this.weight = "";
        this.axis = "";
        this.plate = "";
    }

    public RoutepathrestorationVehicleInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.type = str;
        this.size = str2;
        this.height = str3;
        this.load = str4;
        this.width = str5;
        this.weight = str6;
        this.axis = str7;
        this.plate = str8;
    }
}

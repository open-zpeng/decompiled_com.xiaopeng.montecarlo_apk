package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqVehicle implements Serializable {
    public String axis;
    public GNavigationEtaqueryReqElec elec;
    public String height;
    public String load;
    public String plate;
    public String size;
    public String type;
    public String weight;
    public String width;

    public GNavigationEtaqueryReqVehicle() {
        this.type = "";
        this.size = "";
        this.height = "";
        this.width = "";
        this.load = "";
        this.weight = "";
        this.axis = "";
        this.plate = "";
        this.elec = new GNavigationEtaqueryReqElec();
    }

    public GNavigationEtaqueryReqVehicle(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, GNavigationEtaqueryReqElec gNavigationEtaqueryReqElec) {
        this.type = str;
        this.size = str2;
        this.height = str3;
        this.width = str4;
        this.load = str5;
        this.weight = str6;
        this.axis = str7;
        this.plate = str8;
        this.elec = gNavigationEtaqueryReqElec;
    }
}

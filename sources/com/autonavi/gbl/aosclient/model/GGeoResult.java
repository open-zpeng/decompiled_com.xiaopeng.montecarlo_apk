package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GGeoResult implements Serializable {
    public String cityname;
    public String country;
    public String district;
    public String formattedaddress;
    public double latitude;
    public String level;
    public double longitude;
    public String region;

    public GGeoResult() {
        this.district = "";
        this.level = "";
        this.country = "";
        this.region = "";
        this.cityname = "";
        this.formattedaddress = "";
        this.longitude = 0.0d;
        this.latitude = 0.0d;
    }

    public GGeoResult(String str, String str2, String str3, String str4, String str5, String str6, double d, double d2) {
        this.district = str;
        this.level = str2;
        this.country = str3;
        this.region = str4;
        this.cityname = str5;
        this.formattedaddress = str6;
        this.longitude = d;
        this.latitude = d2;
    }
}

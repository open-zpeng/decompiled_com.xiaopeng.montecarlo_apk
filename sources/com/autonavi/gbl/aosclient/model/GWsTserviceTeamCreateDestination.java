package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamCreateDestination implements Serializable {
    public String address;
    public String city_code;
    public String entranceList;
    public String exitList;
    public String f_nona;
    public String industry;
    public String lat;
    public String lon;
    public String name;
    public String new_type;
    public String parent;
    public String phoneNumbers;
    public String poiType;
    public String poiid;
    public String towards_angle;
    public int x;
    public int y;

    public GWsTserviceTeamCreateDestination() {
        this.address = "";
        this.name = "";
        this.poiid = "";
        this.poiType = "";
        this.city_code = "";
        this.new_type = "";
        this.industry = "";
        this.towards_angle = "";
        this.entranceList = "";
        this.exitList = "";
        this.parent = "";
        this.phoneNumbers = "";
        this.f_nona = "";
        this.lon = "";
        this.lat = "";
        this.x = 0;
        this.y = 0;
    }

    public GWsTserviceTeamCreateDestination(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, int i2) {
        this.address = str;
        this.name = str2;
        this.poiid = str3;
        this.poiType = str4;
        this.city_code = str5;
        this.new_type = str6;
        this.industry = str7;
        this.towards_angle = str8;
        this.entranceList = str9;
        this.exitList = str10;
        this.parent = str11;
        this.phoneNumbers = str12;
        this.f_nona = str13;
        this.lon = str14;
        this.lat = str15;
        this.x = i;
        this.y = i2;
    }
}

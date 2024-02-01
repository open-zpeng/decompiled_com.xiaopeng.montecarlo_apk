package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TeamDestinationInfo implements Serializable {
    public String address;
    public String childType;
    public String city_code;
    public ArrayList<TeamPoint> entranceList;
    public ArrayList<TeamPoint> exitList;
    public String f_nona;
    public String industry;
    public String name;
    public String new_type;
    public String parent;
    public String phoneNumbers;
    public String poiType;
    public String poiid;
    public String towards_angle;
    public int x;
    public int y;

    public TeamDestinationInfo() {
        this.poiid = "";
        this.name = "";
        this.address = "";
        this.x = 0;
        this.y = 0;
        this.city_code = "";
        this.poiType = "";
        this.phoneNumbers = "";
        this.new_type = "";
        this.industry = "";
        this.towards_angle = "";
        this.parent = "";
        this.f_nona = "";
        this.childType = "";
        this.entranceList = new ArrayList<>();
        this.exitList = new ArrayList<>();
    }

    public TeamDestinationInfo(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList<TeamPoint> arrayList, ArrayList<TeamPoint> arrayList2) {
        this.poiid = str;
        this.name = str2;
        this.address = str3;
        this.x = i;
        this.y = i2;
        this.city_code = str4;
        this.poiType = str5;
        this.phoneNumbers = str6;
        this.new_type = str7;
        this.industry = str8;
        this.towards_angle = str9;
        this.parent = str10;
        this.f_nona = str11;
        this.childType = str12;
        this.entranceList = arrayList;
        this.exitList = arrayList2;
    }
}

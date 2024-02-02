package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTserviceTeamResponseDestination implements Serializable {
    public String NaviExtCode;
    public String address;
    public String childType;
    public long city_code;
    public ArrayList<Coord2DInt32> entranceList;
    public ArrayList<Coord2DInt32> exitList;
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

    public GWsTserviceTeamResponseDestination() {
        this.poiid = "";
        this.name = "";
        this.address = "";
        this.poiType = "";
        this.phoneNumbers = "";
        this.new_type = "";
        this.industry = "";
        this.towards_angle = "";
        this.parent = "";
        this.f_nona = "";
        this.childType = "";
        this.x = 0;
        this.y = 0;
        this.city_code = 0L;
        this.entranceList = new ArrayList<>();
        this.exitList = new ArrayList<>();
        this.NaviExtCode = "";
    }

    public GWsTserviceTeamResponseDestination(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, int i2, long j, ArrayList<Coord2DInt32> arrayList, ArrayList<Coord2DInt32> arrayList2, String str12) {
        this.poiid = str;
        this.name = str2;
        this.address = str3;
        this.poiType = str4;
        this.phoneNumbers = str5;
        this.new_type = str6;
        this.industry = str7;
        this.towards_angle = str8;
        this.parent = str9;
        this.f_nona = str10;
        this.childType = str11;
        this.x = i;
        this.y = i2;
        this.city_code = j;
        this.entranceList = arrayList;
        this.exitList = arrayList2;
        this.NaviExtCode = str12;
    }
}

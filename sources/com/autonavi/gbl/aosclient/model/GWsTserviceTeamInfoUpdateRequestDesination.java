package com.autonavi.gbl.aosclient.model;

import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTserviceTeamInfoUpdateRequestDesination implements Serializable {
    public String NaviExtCode;
    public String address;
    public ArrayList<Coord2DInt32> entranceList;
    public ArrayList<Coord2DInt32> exitList;
    public String f_nona;
    public String name;
    public String new_type;
    public String parent;
    public String poiType;
    public String poiid;
    public String towards_angle;
    public long x;
    public long y;

    public GWsTserviceTeamInfoUpdateRequestDesination() {
        this.name = "";
        this.address = "";
        this.poiid = "";
        this.x = 0L;
        this.y = 0L;
        this.entranceList = new ArrayList<>();
        this.exitList = new ArrayList<>();
        this.new_type = "";
        this.poiType = "";
        this.parent = "";
        this.towards_angle = "";
        this.f_nona = "";
        this.NaviExtCode = "";
    }

    public GWsTserviceTeamInfoUpdateRequestDesination(String str, String str2, String str3, long j, long j2, ArrayList<Coord2DInt32> arrayList, ArrayList<Coord2DInt32> arrayList2, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.name = str;
        this.address = str2;
        this.poiid = str3;
        this.x = j;
        this.y = j2;
        this.entranceList = arrayList;
        this.exitList = arrayList2;
        this.new_type = str4;
        this.poiType = str5;
        this.parent = str6;
        this.towards_angle = str7;
        this.f_nona = str8;
        this.NaviExtCode = str9;
    }
}

package com.autonavi.gbl.user.group.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GroupDestination implements Serializable {
    public String address;
    public String childType;
    public String cityCode;
    public Coord2DInt32 display;
    public ArrayList<Coord2DInt32> entranceList;
    public ArrayList<Coord2DInt32> exitList;
    public String floorNo;
    public String industry;
    public String name;
    public String naviExtCode;
    public String newType;
    public String parent;
    public String phoneNumber;
    public String poiId;
    public Coord2DDouble poiLoc;
    public String poiType;
    public String towardsAngle;

    public GroupDestination() {
        this.name = "";
        this.poiId = "";
        this.address = "";
        this.poiType = "";
        this.newType = "";
        this.cityCode = "";
        this.phoneNumber = "";
        this.poiLoc = new Coord2DDouble();
        this.display = new Coord2DInt32();
        this.industry = "";
        this.towardsAngle = "";
        this.entranceList = new ArrayList<>();
        this.exitList = new ArrayList<>();
        this.parent = "";
        this.floorNo = "";
        this.childType = "";
        this.naviExtCode = "";
    }

    public GroupDestination(String str, String str2, String str3, String str4, String str5, String str6, String str7, Coord2DDouble coord2DDouble, Coord2DInt32 coord2DInt32, String str8, String str9, ArrayList<Coord2DInt32> arrayList, ArrayList<Coord2DInt32> arrayList2, String str10, String str11, String str12, String str13) {
        this.name = str;
        this.poiId = str2;
        this.address = str3;
        this.poiType = str4;
        this.newType = str5;
        this.cityCode = str6;
        this.phoneNumber = str7;
        this.poiLoc = coord2DDouble;
        this.display = coord2DInt32;
        this.industry = str8;
        this.towardsAngle = str9;
        this.entranceList = arrayList;
        this.exitList = arrayList2;
        this.parent = str10;
        this.floorNo = str11;
        this.childType = str12;
        this.naviExtCode = str13;
    }
}

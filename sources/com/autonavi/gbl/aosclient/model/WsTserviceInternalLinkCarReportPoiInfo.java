package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsTserviceInternalLinkCarReportPoiInfo implements Serializable {
    public String adcode;
    public String address;
    public String childType;
    public String cityCode;
    public String end_poi_extension;
    public ArrayList<EntranceInfo> entranceList;
    public ArrayList<ExitInfo> exitList;
    public String f_nona;
    public String floor;
    public String industry;
    public boolean is_gpspoint;
    public double lat;
    public double lon;
    public String name;
    public String new_type;
    public String parentID;
    public String phoneNumbers;
    public String poiid;
    public String sublayerid;
    public String transparent;
    public long x;
    public long y;

    public WsTserviceInternalLinkCarReportPoiInfo() {
        this.poiid = "";
        this.name = "";
        this.address = "";
        this.phoneNumbers = "";
        this.new_type = "";
        this.parentID = "";
        this.is_gpspoint = false;
        this.sublayerid = "";
        this.x = 0L;
        this.y = 0L;
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.cityCode = "";
        this.adcode = "";
        this.industry = "";
        this.transparent = "";
        this.childType = "";
        this.f_nona = "";
        this.floor = "";
        this.entranceList = new ArrayList<>();
        this.exitList = new ArrayList<>();
        this.end_poi_extension = "";
    }

    public WsTserviceInternalLinkCarReportPoiInfo(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, long j, long j2, double d, double d2, String str8, String str9, String str10, String str11, String str12, String str13, String str14, ArrayList<EntranceInfo> arrayList, ArrayList<ExitInfo> arrayList2, String str15) {
        this.poiid = str;
        this.name = str2;
        this.address = str3;
        this.phoneNumbers = str4;
        this.new_type = str5;
        this.parentID = str6;
        this.is_gpspoint = z;
        this.sublayerid = str7;
        this.x = j;
        this.y = j2;
        this.lon = d;
        this.lat = d2;
        this.cityCode = str8;
        this.adcode = str9;
        this.industry = str10;
        this.transparent = str11;
        this.childType = str12;
        this.f_nona = str13;
        this.floor = str14;
        this.entranceList = arrayList;
        this.exitList = arrayList2;
        this.end_poi_extension = str15;
    }
}

package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchNearestResult implements Serializable {
    public int adcode;
    public String areacode;
    public String city;
    public int cityadcode;
    public int code;
    public ArrayList<NearestCross> crossList;
    public String desc;
    public String district;
    public int districtadcode;
    public int iPoiType;
    public int iTotal;
    public String message;
    public ArrayList<NearestPoi> poi_list;
    public String pos;
    public String province;
    public int provinceadcode;
    public String result;
    public ArrayList<NearestRoad> roadList;
    public String timestamp;
    public String version;

    public SearchNearestResult() {
        this.iPoiType = 0;
        this.version = "";
        this.result = "";
        this.code = -1;
        this.message = "";
        this.timestamp = "";
        this.province = "";
        this.provinceadcode = 0;
        this.city = "";
        this.cityadcode = 0;
        this.adcode = 0;
        this.areacode = "";
        this.district = "";
        this.districtadcode = 0;
        this.desc = "";
        this.pos = "";
        this.iTotal = 0;
        this.poi_list = new ArrayList<>();
        this.roadList = new ArrayList<>();
        this.crossList = new ArrayList<>();
    }

    public SearchNearestResult(int i, String str, String str2, int i2, String str3, String str4, String str5, int i3, String str6, int i4, int i5, String str7, String str8, int i6, String str9, String str10, int i7, ArrayList<NearestPoi> arrayList, ArrayList<NearestRoad> arrayList2, ArrayList<NearestCross> arrayList3) {
        this.iPoiType = i;
        this.version = str;
        this.result = str2;
        this.code = i2;
        this.message = str3;
        this.timestamp = str4;
        this.province = str5;
        this.provinceadcode = i3;
        this.city = str6;
        this.cityadcode = i4;
        this.adcode = i5;
        this.areacode = str7;
        this.district = str8;
        this.districtadcode = i6;
        this.desc = str9;
        this.pos = str10;
        this.iTotal = i7;
        this.poi_list = arrayList;
        this.roadList = arrayList2;
        this.crossList = arrayList3;
    }
}

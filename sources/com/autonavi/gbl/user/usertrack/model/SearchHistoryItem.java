package com.autonavi.gbl.user.usertrack.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchHistoryItem implements Serializable {
    public String adcode;
    public String address;
    public String category;
    public int childType;
    public String citycode;
    public int datatype;
    public String datatype_spec;
    public String display_info;
    public String district;
    public int endPoiExtension;
    public String floorNo;
    public String func_text;
    public int history_type;
    public int iconinfo;
    public String id;
    public String ignore_district;
    public String name;
    public String num_review;
    public String parent;
    public String poi;
    public String poi_tag;
    public String poiid;
    public String rich_rating;
    public String search_query;
    public ArrayList<String> search_query_set;
    public ArrayList<String> search_tag;
    public String short_name;
    public String super_address;
    public String terminals;
    public String towardsAngle;
    public int type;
    public long update_time;
    public String version;
    public double x;
    public double x_entr;
    public double y;
    public double y_entr;

    public SearchHistoryItem() {
        this.name = "";
        this.poiid = "";
        this.id = "";
        this.type = 0;
        this.datatype = 0;
        this.x = 0.0d;
        this.y = 0.0d;
        this.x_entr = 0.0d;
        this.y_entr = 0.0d;
        this.update_time = 0L;
        this.history_type = 0;
        this.iconinfo = 0;
        this.adcode = "";
        this.district = "";
        this.address = "";
        this.poi_tag = "";
        this.func_text = "";
        this.short_name = "";
        this.display_info = "";
        this.search_query = "";
        this.terminals = "";
        this.ignore_district = "";
        this.search_tag = new ArrayList<>();
        this.search_query_set = new ArrayList<>();
        this.rich_rating = "";
        this.num_review = "";
        this.category = "";
        this.super_address = "";
        this.datatype_spec = "";
        this.poi = "";
        this.citycode = "";
        this.version = "";
        this.parent = "";
        this.childType = 0;
        this.towardsAngle = "";
        this.floorNo = "";
        this.endPoiExtension = 0;
    }

    public SearchHistoryItem(String str, String str2, String str3, int i, int i2, double d, double d2, double d3, double d4, long j, int i3, int i4, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, int i5, String str23, String str24, int i6) {
        this.name = str;
        this.poiid = str2;
        this.id = str3;
        this.type = i;
        this.datatype = i2;
        this.x = d;
        this.y = d2;
        this.x_entr = d3;
        this.y_entr = d4;
        this.update_time = j;
        this.history_type = i3;
        this.iconinfo = i4;
        this.adcode = str4;
        this.district = str5;
        this.address = str6;
        this.poi_tag = str7;
        this.func_text = str8;
        this.short_name = str9;
        this.display_info = str10;
        this.search_query = str11;
        this.terminals = str12;
        this.ignore_district = str13;
        this.search_tag = arrayList;
        this.search_query_set = arrayList2;
        this.rich_rating = str14;
        this.num_review = str15;
        this.category = str16;
        this.super_address = str17;
        this.datatype_spec = str18;
        this.poi = str19;
        this.citycode = str20;
        this.version = str21;
        this.parent = str22;
        this.childType = i5;
        this.towardsAngle = str23;
        this.floorNo = str24;
        this.endPoiExtension = i6;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataDataItem implements Serializable {
    public String address;
    public String display_name;
    public String dist_to_via;
    public String distance;
    public ArrayList<WsNavigationDynamicDataEntranceListItem> entranceList;
    public String eta_to_via;
    public ArrayList<WsNavigationDynamicDataEntranceListItem> exitList;
    public double lat;
    public double lon;
    public String name;
    public String new_type;
    public String parentID;
    public String poiid;
    public String tag;
    public String travel_time;
    public int type;

    public WsNavigationDynamicDataDataItem() {
        this.poiid = "";
        this.name = "";
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.new_type = "";
        this.address = "";
        this.parentID = "";
        this.entranceList = new ArrayList<>();
        this.exitList = new ArrayList<>();
        this.display_name = "";
        this.tag = "";
        this.distance = "";
        this.dist_to_via = "";
        this.eta_to_via = "";
        this.travel_time = "";
        this.type = 0;
    }

    public WsNavigationDynamicDataDataItem(String str, String str2, double d, double d2, String str3, String str4, String str5, ArrayList<WsNavigationDynamicDataEntranceListItem> arrayList, ArrayList<WsNavigationDynamicDataEntranceListItem> arrayList2, String str6, String str7, String str8, String str9, String str10, String str11, int i) {
        this.poiid = str;
        this.name = str2;
        this.lon = d;
        this.lat = d2;
        this.new_type = str3;
        this.address = str4;
        this.parentID = str5;
        this.entranceList = arrayList;
        this.exitList = arrayList2;
        this.display_name = str6;
        this.tag = str7;
        this.distance = str8;
        this.dist_to_via = str9;
        this.eta_to_via = str10;
        this.travel_time = str11;
        this.type = i;
    }
}

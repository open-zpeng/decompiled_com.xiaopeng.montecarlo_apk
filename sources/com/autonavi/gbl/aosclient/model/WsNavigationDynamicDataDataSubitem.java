package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataDataSubitem implements Serializable {
    public String building_status;
    public String business;
    public int chargecount;
    public int chargeusable;
    public ArrayList<WsNavigationDynamicDataChild> children;
    public long dynamic_id;
    public String id;
    public int is_charge;
    public String name;
    public long path_id;
    public ArrayList<Integer> path_ids;
    public String type;
    public String usingid;

    public WsNavigationDynamicDataDataSubitem() {
        this.building_status = "";
        this.business = "";
        this.children = new ArrayList<>();
        this.is_charge = 0;
        this.chargecount = 0;
        this.chargeusable = 0;
        this.path_id = 0L;
        this.path_ids = new ArrayList<>();
        this.dynamic_id = 0L;
        this.name = "";
        this.id = "";
        this.type = "";
        this.usingid = "";
    }

    public WsNavigationDynamicDataDataSubitem(String str, String str2, ArrayList<WsNavigationDynamicDataChild> arrayList, int i, int i2, int i3, long j, ArrayList<Integer> arrayList2, long j2, String str3, String str4, String str5, String str6) {
        this.building_status = str;
        this.business = str2;
        this.children = arrayList;
        this.is_charge = i;
        this.chargecount = i2;
        this.chargeusable = i3;
        this.path_id = j;
        this.path_ids = arrayList2;
        this.dynamic_id = j2;
        this.name = str3;
        this.id = str4;
        this.type = str5;
        this.usingid = str6;
    }
}

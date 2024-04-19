package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataPowerTrendItem implements Serializable {
    public int actual_diatance;
    public String actual_title;
    public int air_switch;
    public int consume_index;
    public double estimate_diff;
    public int estimate_distance;
    public String estimate_title;
    public int path_id;
    public ArrayList<WsNavigationDynamicDataPowerDataItem> power_data;
    public String title;
    public int turns_interval;
    public ArrayList<WsNavigationDynamicDataTurnsTextItem> turns_text;

    public WsNavigationDynamicDataPowerTrendItem() {
        this.path_id = 0;
        this.air_switch = 0;
        this.title = "";
        this.estimate_distance = 0;
        this.estimate_title = "";
        this.estimate_diff = 0.0d;
        this.consume_index = 0;
        this.actual_diatance = 0;
        this.actual_title = "";
        this.turns_text = new ArrayList<>();
        this.turns_interval = 0;
        this.power_data = new ArrayList<>();
    }

    public WsNavigationDynamicDataPowerTrendItem(int i, int i2, String str, int i3, String str2, double d, int i4, int i5, String str3, ArrayList<WsNavigationDynamicDataTurnsTextItem> arrayList, int i6, ArrayList<WsNavigationDynamicDataPowerDataItem> arrayList2) {
        this.path_id = i;
        this.air_switch = i2;
        this.title = str;
        this.estimate_distance = i3;
        this.estimate_title = str2;
        this.estimate_diff = d;
        this.consume_index = i4;
        this.actual_diatance = i5;
        this.actual_title = str3;
        this.turns_text = arrayList;
        this.turns_interval = i6;
        this.power_data = arrayList2;
    }
}

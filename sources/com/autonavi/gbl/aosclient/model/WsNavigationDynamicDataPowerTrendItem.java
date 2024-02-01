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
    public long path_id;
    public ArrayList<WsNavigationDynamicDataPowerDataItem> power_data;
    public String title;
    public int turns_interval;
    public ArrayList<WsNavigationDynamicDataTurnsTextItem> turns_text;

    public WsNavigationDynamicDataPowerTrendItem() {
        this.path_id = 0L;
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

    public WsNavigationDynamicDataPowerTrendItem(long j, int i, String str, int i2, String str2, double d, int i3, int i4, String str3, ArrayList<WsNavigationDynamicDataTurnsTextItem> arrayList, int i5, ArrayList<WsNavigationDynamicDataPowerDataItem> arrayList2) {
        this.path_id = j;
        this.air_switch = i;
        this.title = str;
        this.estimate_distance = i2;
        this.estimate_title = str2;
        this.estimate_diff = d;
        this.consume_index = i3;
        this.actual_diatance = i4;
        this.actual_title = str3;
        this.turns_text = arrayList;
        this.turns_interval = i5;
        this.power_data = arrayList2;
    }
}

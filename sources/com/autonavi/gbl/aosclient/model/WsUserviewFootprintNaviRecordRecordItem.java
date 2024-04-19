package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsUserviewFootprintNaviRecordRecordItem implements Serializable {
    public int act_mstimestamp;
    public String actual_destination;
    public boolean arrived;
    public WsUserviewFootprintNaviRecordCarNavi car_navi;
    public String destination;
    public String month;
    public int month_act_times;
    public int month_distance;
    public String navi_id;
    public String origin;
    public int travel_id;
    public int travel_type;

    public WsUserviewFootprintNaviRecordRecordItem() {
        this.arrived = false;
        this.actual_destination = "";
        this.month_act_times = 0;
        this.month_distance = 0;
        this.month = "";
        this.travel_id = 0;
        this.navi_id = "";
        this.travel_type = 0;
        this.origin = "";
        this.destination = "";
        this.act_mstimestamp = 0;
        this.car_navi = new WsUserviewFootprintNaviRecordCarNavi();
    }

    public WsUserviewFootprintNaviRecordRecordItem(boolean z, String str, int i, int i2, String str2, int i3, String str3, int i4, String str4, String str5, int i5, WsUserviewFootprintNaviRecordCarNavi wsUserviewFootprintNaviRecordCarNavi) {
        this.arrived = z;
        this.actual_destination = str;
        this.month_act_times = i;
        this.month_distance = i2;
        this.month = str2;
        this.travel_id = i3;
        this.navi_id = str3;
        this.travel_type = i4;
        this.origin = str4;
        this.destination = str5;
        this.act_mstimestamp = i5;
        this.car_navi = wsUserviewFootprintNaviRecordCarNavi;
    }
}

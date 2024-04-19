package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsUserviewFootprintNaviRecordCarNavi implements Serializable {
    public int avg_speed;
    public String avg_speed_str;
    public String avg_speed_unit;
    public int distance;
    public int duration;
    public int max_speed;
    public String max_speed_str;
    public String max_speed_unit;

    public WsUserviewFootprintNaviRecordCarNavi() {
        this.duration = 0;
        this.distance = 0;
        this.avg_speed = 0;
        this.max_speed = 0;
        this.avg_speed_str = "";
        this.avg_speed_unit = "";
        this.max_speed_str = "";
        this.max_speed_unit = "";
    }

    public WsUserviewFootprintNaviRecordCarNavi(int i, int i2, int i3, int i4, String str, String str2, String str3, String str4) {
        this.duration = i;
        this.distance = i2;
        this.avg_speed = i3;
        this.max_speed = i4;
        this.avg_speed_str = str;
        this.avg_speed_unit = str2;
        this.max_speed_str = str3;
        this.max_speed_unit = str4;
    }
}

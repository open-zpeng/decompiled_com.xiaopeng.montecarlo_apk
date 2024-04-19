package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsHcp3ChargeListContentItem implements Serializable {
    public String address;
    public int charge_left;
    public long distance;
    public String eaddress;
    public String ename;
    public double lat;
    public double lon;
    public String name;
    public String poiid;
    public long travel_time;

    public WsHcp3ChargeListContentItem() {
        this.address = "";
        this.charge_left = 0;
        this.distance = 0L;
        this.eaddress = "";
        this.ename = "";
        this.lat = 0.0d;
        this.lon = 0.0d;
        this.name = "";
        this.poiid = "";
        this.travel_time = 0L;
    }

    public WsHcp3ChargeListContentItem(String str, int i, long j, String str2, String str3, double d, double d2, String str4, String str5, long j2) {
        this.address = str;
        this.charge_left = i;
        this.distance = j;
        this.eaddress = str2;
        this.ename = str3;
        this.lat = d;
        this.lon = d2;
        this.name = str4;
        this.poiid = str5;
        this.travel_time = j2;
    }
}

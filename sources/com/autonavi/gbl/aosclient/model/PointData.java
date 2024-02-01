package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PointData implements Serializable {
    public String address;
    public String id;
    public String lat;
    public String lon;
    public String name;
    public RouteInfoData route_info;

    public PointData() {
        this.id = "";
        this.name = "";
        this.address = "";
        this.lon = "";
        this.lat = "";
        this.route_info = new RouteInfoData();
    }

    public PointData(String str, String str2, String str3, String str4, String str5, RouteInfoData routeInfoData) {
        this.id = str;
        this.name = str2;
        this.address = str3;
        this.lon = str4;
        this.lat = str5;
        this.route_info = routeInfoData;
    }
}

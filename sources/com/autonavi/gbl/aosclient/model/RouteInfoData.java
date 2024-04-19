package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RouteInfoData implements Serializable {
    public ArrayList<RouteInfoDataDetailItem> detail;
    public double distance;
    public double travel_time;

    public RouteInfoData() {
        this.distance = 0.0d;
        this.travel_time = 0.0d;
        this.detail = new ArrayList<>();
    }

    public RouteInfoData(double d, double d2, ArrayList<RouteInfoDataDetailItem> arrayList) {
        this.distance = d;
        this.travel_time = d2;
        this.detail = arrayList;
    }
}

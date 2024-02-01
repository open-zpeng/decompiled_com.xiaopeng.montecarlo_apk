package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GNavigationEtaqueryAckRouteListPath implements Serializable {
    public int charge_left;
    public int distance;
    public int rest_title_type;
    public int taxi_fare;
    public long travel_time;

    public GNavigationEtaqueryAckRouteListPath() {
        this.distance = 0;
        this.travel_time = 0L;
        this.taxi_fare = 0;
        this.charge_left = 0;
        this.rest_title_type = -1;
    }

    public GNavigationEtaqueryAckRouteListPath(int i, long j, int i2, int i3, int i4) {
        this.distance = i;
        this.travel_time = j;
        this.taxi_fare = i2;
        this.charge_left = i3;
        this.rest_title_type = i4;
    }
}

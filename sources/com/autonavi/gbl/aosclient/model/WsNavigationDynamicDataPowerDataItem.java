package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataPowerDataItem implements Serializable {
    public int air_power;
    public int distance;
    public int length;
    public int no_air_power;
    public int slope;
    public int traffic;

    public WsNavigationDynamicDataPowerDataItem() {
        this.length = 0;
        this.distance = 0;
        this.no_air_power = 0;
        this.air_power = 0;
        this.traffic = 0;
        this.slope = 0;
    }

    public WsNavigationDynamicDataPowerDataItem(int i, int i2, int i3, int i4, int i5, int i6) {
        this.length = i;
        this.distance = i2;
        this.no_air_power = i3;
        this.air_power = i4;
        this.traffic = i5;
        this.slope = i6;
    }
}

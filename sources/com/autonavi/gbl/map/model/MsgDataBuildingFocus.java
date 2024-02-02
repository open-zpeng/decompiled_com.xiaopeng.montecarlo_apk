package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MsgDataBuildingFocus implements Serializable {
    public boolean isHighLight;
    public double lat;
    public double lon;
    public int mainKey;
    public int subKey;

    public MsgDataBuildingFocus() {
        this.isHighLight = false;
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.mainKey = 0;
        this.subKey = 0;
    }

    public MsgDataBuildingFocus(boolean z, double d, double d2, int i, int i2) {
        this.isHighLight = z;
        this.lon = d;
        this.lat = d2;
        this.mainKey = i;
        this.subKey = i2;
    }
}

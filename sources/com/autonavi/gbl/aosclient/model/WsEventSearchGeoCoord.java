package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsEventSearchGeoCoord implements Serializable {
    public int latitude;
    public int longitude;

    public WsEventSearchGeoCoord() {
        this.longitude = 0;
        this.latitude = 0;
    }

    public WsEventSearchGeoCoord(int i, int i2) {
        this.longitude = i;
        this.latitude = i2;
    }
}

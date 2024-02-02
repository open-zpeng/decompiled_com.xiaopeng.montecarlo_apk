package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAudiHcp3EventSearchGeoCoord implements Serializable {
    public int latitude;
    public int longitude;

    public WsAudiHcp3EventSearchGeoCoord() {
        this.longitude = 0;
        this.latitude = 0;
    }

    public WsAudiHcp3EventSearchGeoCoord(int i, int i2) {
        this.longitude = i;
        this.latitude = i2;
    }
}

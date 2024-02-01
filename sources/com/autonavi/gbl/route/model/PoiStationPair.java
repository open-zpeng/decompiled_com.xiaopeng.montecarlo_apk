package com.autonavi.gbl.route.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PoiStationPair implements Serializable {
    public String poiID;
    public String stationID;

    public PoiStationPair() {
        this.poiID = "";
        this.stationID = "";
    }

    public PoiStationPair(String str, String str2) {
        this.poiID = str;
        this.stationID = str2;
    }
}

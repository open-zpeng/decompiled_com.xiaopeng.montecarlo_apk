package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataPoiidChargingPointPointData implements Serializable {
    public String poiid;
    public String station_id;

    public WsNavigationDynamicDataPoiidChargingPointPointData() {
        this.poiid = "";
        this.station_id = "";
    }

    public WsNavigationDynamicDataPoiidChargingPointPointData(String str, String str2) {
        this.poiid = str;
        this.station_id = str2;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataPoiidChargingPoint implements Serializable {
    public long pathId;
    public ArrayList<WsNavigationDynamicDataPoiidChargingPointPointData> point_data;

    public WsNavigationDynamicDataPoiidChargingPoint() {
        this.pathId = 0L;
        this.point_data = new ArrayList<>();
    }

    public WsNavigationDynamicDataPoiidChargingPoint(long j, ArrayList<WsNavigationDynamicDataPoiidChargingPointPointData> arrayList) {
        this.pathId = j;
        this.point_data = arrayList;
    }
}

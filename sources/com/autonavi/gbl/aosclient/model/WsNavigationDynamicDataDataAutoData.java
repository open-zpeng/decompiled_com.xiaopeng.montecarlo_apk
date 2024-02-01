package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataDataAutoData implements Serializable {
    public ArrayList<WsNavigationDynamicDataPoiidChargingPoint> poiid_charging_point;

    public WsNavigationDynamicDataDataAutoData() {
        this.poiid_charging_point = new ArrayList<>();
    }

    public WsNavigationDynamicDataDataAutoData(ArrayList<WsNavigationDynamicDataPoiidChargingPoint> arrayList) {
        this.poiid_charging_point = arrayList;
    }
}

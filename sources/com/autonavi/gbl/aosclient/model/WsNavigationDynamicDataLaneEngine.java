package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataLaneEngine implements Serializable {
    public ArrayList<WsNavigationDynamicDataRtkCityItem> rtk_city;

    public WsNavigationDynamicDataLaneEngine() {
        this.rtk_city = new ArrayList<>();
    }

    public WsNavigationDynamicDataLaneEngine(ArrayList<WsNavigationDynamicDataRtkCityItem> arrayList) {
        this.rtk_city = arrayList;
    }
}

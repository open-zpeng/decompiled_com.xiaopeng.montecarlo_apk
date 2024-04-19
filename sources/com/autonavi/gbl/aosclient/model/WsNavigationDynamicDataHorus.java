package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataHorus implements Serializable {
    public ArrayList<WsNavigationDynamicDataChargeDataItem> charge_data;

    public WsNavigationDynamicDataHorus() {
        this.charge_data = new ArrayList<>();
    }

    public WsNavigationDynamicDataHorus(ArrayList<WsNavigationDynamicDataChargeDataItem> arrayList) {
        this.charge_data = arrayList;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataChargeDataItem implements Serializable {
    public ArrayList<WsNavigationDynamicDataDataItem> data;
    public int path_id;

    public WsNavigationDynamicDataChargeDataItem() {
        this.path_id = 0;
        this.data = new ArrayList<>();
    }

    public WsNavigationDynamicDataChargeDataItem(int i, ArrayList<WsNavigationDynamicDataDataItem> arrayList) {
        this.path_id = i;
        this.data = arrayList;
    }
}

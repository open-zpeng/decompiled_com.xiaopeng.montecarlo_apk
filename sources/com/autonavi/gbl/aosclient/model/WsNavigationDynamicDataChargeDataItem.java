package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataChargeDataItem implements Serializable {
    public ArrayList<WsNavigationDynamicDataDataItem> data;
    public long path_id;

    public WsNavigationDynamicDataChargeDataItem() {
        this.path_id = 0L;
        this.data = new ArrayList<>();
    }

    public WsNavigationDynamicDataChargeDataItem(long j, ArrayList<WsNavigationDynamicDataDataItem> arrayList) {
        this.path_id = j;
        this.data = arrayList;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRequestPoiidList implements Serializable {
    public long pathid;
    public ArrayList<String> poiids;

    public WsNavigationDynamicDataRequestPoiidList() {
        this.pathid = 0L;
        this.poiids = new ArrayList<>();
    }

    public WsNavigationDynamicDataRequestPoiidList(long j, ArrayList<String> arrayList) {
        this.pathid = j;
        this.poiids = arrayList;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EventSyncCommonPushDetail implements Serializable {
    public ArrayList<EventSyncCommonPushDetailItem> maps;

    public EventSyncCommonPushDetail() {
        this.maps = new ArrayList<>();
    }

    public EventSyncCommonPushDetail(ArrayList<EventSyncCommonPushDetailItem> arrayList) {
        this.maps = arrayList;
    }
}

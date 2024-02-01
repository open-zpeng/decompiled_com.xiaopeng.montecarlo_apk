package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsEventSearchEventResult implements Serializable {
    public ArrayList<WsEventSearchUgcEventItem> ugcEvent;

    public WsEventSearchEventResult() {
        this.ugcEvent = new ArrayList<>();
    }

    public WsEventSearchEventResult(ArrayList<WsEventSearchUgcEventItem> arrayList) {
        this.ugcEvent = arrayList;
    }
}

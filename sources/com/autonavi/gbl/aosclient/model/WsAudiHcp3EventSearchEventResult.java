package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAudiHcp3EventSearchEventResult implements Serializable {
    public ArrayList<WsAudiHcp3EventSearchUgcEventItem> ugcEvent;

    public WsAudiHcp3EventSearchEventResult() {
        this.ugcEvent = new ArrayList<>();
    }

    public WsAudiHcp3EventSearchEventResult(ArrayList<WsAudiHcp3EventSearchUgcEventItem> arrayList) {
        this.ugcEvent = arrayList;
    }
}

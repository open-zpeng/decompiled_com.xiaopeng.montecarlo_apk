package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAudiHcp3EventSearchData implements Serializable {
    public ArrayList<WsAudiHcp3EventSearchEventResult> eventResults;

    public WsAudiHcp3EventSearchData() {
        this.eventResults = new ArrayList<>();
    }

    public WsAudiHcp3EventSearchData(ArrayList<WsAudiHcp3EventSearchEventResult> arrayList) {
        this.eventResults = arrayList;
    }
}

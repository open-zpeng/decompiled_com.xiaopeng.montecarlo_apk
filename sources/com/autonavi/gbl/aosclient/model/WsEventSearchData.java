package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsEventSearchData implements Serializable {
    public ArrayList<WsEventSearchEventResult> eventResults;

    public WsEventSearchData() {
        this.eventResults = new ArrayList<>();
    }

    public WsEventSearchData(ArrayList<WsEventSearchEventResult> arrayList) {
        this.eventResults = arrayList;
    }
}

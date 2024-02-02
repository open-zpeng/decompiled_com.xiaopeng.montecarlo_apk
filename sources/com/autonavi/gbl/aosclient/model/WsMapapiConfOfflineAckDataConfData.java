package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsMapapiConfOfflineAckDataConfData implements Serializable {
    public ArrayList<WsMapapiConfOfflineAckDataConfDataInfo> vecDataInfo;

    public WsMapapiConfOfflineAckDataConfData() {
        this.vecDataInfo = new ArrayList<>();
    }

    public WsMapapiConfOfflineAckDataConfData(ArrayList<WsMapapiConfOfflineAckDataConfDataInfo> arrayList) {
        this.vecDataInfo = arrayList;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsMapapiConfOfflineAckData implements Serializable {
    public WsMapapiConfOfflineAckDataConfData conf_data;

    public WsMapapiConfOfflineAckData() {
        this.conf_data = new WsMapapiConfOfflineAckDataConfData();
    }

    public WsMapapiConfOfflineAckData(WsMapapiConfOfflineAckDataConfData wsMapapiConfOfflineAckDataConfData) {
        this.conf_data = wsMapapiConfOfflineAckDataConfData;
    }
}

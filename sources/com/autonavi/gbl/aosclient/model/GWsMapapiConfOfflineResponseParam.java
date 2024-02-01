package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiConfOfflineResponseParam extends BLResponseBase implements Serializable {
    public WsMapapiConfOfflineAckData data = new WsMapapiConfOfflineAckData();

    public GWsMapapiConfOfflineResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MAPAPI_CONF_OFFLINE;
        this.mNetworkStatus = 0;
    }
}

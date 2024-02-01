package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiAutoInitResponseParam extends BLResponseBase implements Serializable {
    public WsMapapiAutoInitAckDatas datas = new WsMapapiAutoInitAckDatas();

    public GWsMapapiAutoInitResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MAPAPI_AUTO_INIT;
        this.mNetworkStatus = 0;
    }
}

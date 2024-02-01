package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiRoadResponseParam extends BLResponseBase implements Serializable {
    public String data = "";

    public GWsMapapiRoadResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MAPAPI_CUSTOM2_ROAD;
        this.mNetworkStatus = 0;
    }
}

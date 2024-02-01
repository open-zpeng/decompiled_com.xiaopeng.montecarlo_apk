package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAuthcarServiceEnableResponseParam extends BLResponseBase implements Serializable {
    public String errdetail = "";
    public WsAuthcarServiceEnableData data = new WsAuthcarServiceEnableData();

    public GWsAuthcarServiceEnableResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_REST_WS_AUTHCAR_SERVICE_ENABLE;
        this.mNetworkStatus = 0;
    }
}

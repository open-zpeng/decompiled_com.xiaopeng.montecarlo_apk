package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAuthcarTokenResponseParam extends BLResponseBase implements Serializable {
    public String errdetail = "";
    public WsAuthcarTokenData data = new WsAuthcarTokenData();
    public String raw = "";

    public GWsAuthcarTokenResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_REST_WS_AUTHCAR_TOKEN;
        this.mNetworkStatus = 0;
    }
}

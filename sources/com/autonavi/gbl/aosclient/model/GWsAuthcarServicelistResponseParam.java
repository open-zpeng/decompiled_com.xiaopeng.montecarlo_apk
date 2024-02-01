package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAuthcarServicelistResponseParam extends BLResponseBase implements Serializable {
    public String json_data = "";
    public String errdetail = "";
    public WsAuthcarServicelistData data = new WsAuthcarServicelistData();

    public GWsAuthcarServicelistResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_REST_WS_AUTHCAR_SERVICELIST;
        this.mNetworkStatus = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAuthcarServiceProvisionResponseParam extends BLResponseBase implements Serializable {
    public String errdetail = "";
    public WsAuthcarServiceProvisionData data = new WsAuthcarServiceProvisionData();

    public GWsAuthcarServiceProvisionResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_REST_WS_AUTHCAR_SERVICE_PROVISION;
        this.mNetworkStatus = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAuthcarServiceProvisionRequestParam extends BLRequestBase implements Serializable {
    public String vid = "";
    public String pid = "";
    public String sids = "";

    public GWsAuthcarServiceProvisionRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_REST_WS_AUTHCAR_SERVICE_PROVISION;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

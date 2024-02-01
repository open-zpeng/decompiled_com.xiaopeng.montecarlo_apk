package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAuthcarServiceEnableRequestParam extends BLRequestBase implements Serializable {
    public String vid = "";
    public String pid = "";
    public String sid = "";

    public GWsAuthcarServiceEnableRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_REST_WS_AUTHCAR_SERVICE_ENABLE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

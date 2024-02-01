package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAuthcarServicelistRequestParam extends BLRequestBase implements Serializable {
    public String vid = "";
    public String pid = "";
    public String version = "";

    public GWsAuthcarServicelistRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_REST_WS_AUTHCAR_SERVICELIST;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

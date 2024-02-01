package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAuthcarTokenRequestParam extends BLRequestBase implements Serializable {
    public String vid = "";
    public String pid = "";
    public String grant_type = "";
    public String scope = "";
    public String terminal = "";

    public GWsAuthcarTokenRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_REST_WS_AUTHCAR_TOKEN;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

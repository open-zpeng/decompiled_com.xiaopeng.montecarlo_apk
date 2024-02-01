package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GImGetLoginTokenResponseParam extends BLResponseBase implements Serializable {
    public WsImGetLoginTokenData data = new WsImGetLoginTokenData();

    public GImGetLoginTokenResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_IM_GET_LOGIN_TOKEN;
        this.mNetworkStatus = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GImGetLoginTokenRequestParam extends BLRequestBase implements Serializable {
    public String deviceId = "";
    public String appCode = "";
    public String appKey = "";
    public String appUid = "";
    public String sessionId = "";

    public GImGetLoginTokenRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_IM_GET_LOGIN_TOKEN;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GImGetAppuidRequestParam extends BLRequestBase implements Serializable {
    public String appCode = "";
    public String sessionId = "";

    public GImGetAppuidRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_IM_GET_APPUID;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

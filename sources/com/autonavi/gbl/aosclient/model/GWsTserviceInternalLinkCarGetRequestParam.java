package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceInternalLinkCarGetRequestParam extends BLRequestBase implements Serializable {
    public String appType = "";

    public GWsTserviceInternalLinkCarGetRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TSERVICE_INTERNAL_LINK_CAR_GET;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceInternalLinkAutoReportRequestParam extends BLRequestBase implements Serializable {
    public int bizType = 0;
    public String data = "";

    public GWsTserviceInternalLinkAutoReportRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TSERVICE_INTERNAL_LINK_AUTO_REPORT;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

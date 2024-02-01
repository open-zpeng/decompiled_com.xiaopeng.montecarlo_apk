package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceDatainterflowGetRequestParam extends BLRequestBase implements Serializable {
    public String ukey = "";

    public GWsTserviceDatainterflowGetRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TSERVICE_DATAINTERFLOW_GET;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

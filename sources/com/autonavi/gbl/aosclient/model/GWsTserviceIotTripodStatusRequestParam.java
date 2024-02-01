package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotTripodStatusRequestParam extends BLRequestBase implements Serializable {
    public String sn = "";
    public String uid = "";
    public String sessionid = "";
    public String dip = "";

    public GWsTserviceIotTripodStatusRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_TRIPOD_STATUS;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotTripodEventRequestParam extends BLRequestBase implements Serializable {
    public String sn = "";
    public String uid = "";
    public String sessionid = "";
    public String dip = "";

    public GWsTserviceIotTripodEventRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_TRIPOD_EVENT;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

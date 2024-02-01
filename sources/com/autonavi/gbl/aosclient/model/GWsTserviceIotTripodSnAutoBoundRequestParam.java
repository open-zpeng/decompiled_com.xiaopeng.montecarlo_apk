package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotTripodSnAutoBoundRequestParam extends BLRequestBase implements Serializable {
    public String diu = "";
    public String adiu = "";
    public String sessionid = "";
    public String dip = "";

    public GWsTserviceIotTripodSnAutoBoundRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_TRIPOD_SN_AUTO_BOUND;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

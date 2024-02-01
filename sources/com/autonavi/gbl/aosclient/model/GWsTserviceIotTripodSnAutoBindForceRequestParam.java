package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotTripodSnAutoBindForceRequestParam extends BLRequestBase implements Serializable {
    public String uid = "";
    public String diu = "";
    public String adiu = "";
    public String sn = "";
    public String sessionid = "";
    public String dip = "";

    public GWsTserviceIotTripodSnAutoBindForceRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_TRIPOD_SN_AUTO_BIND_FORCE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

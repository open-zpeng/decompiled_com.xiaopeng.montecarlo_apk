package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotTripodSnAutoBindForceResponseParam extends BLResponseBase implements Serializable {
    public String data = "";

    public GWsTserviceIotTripodSnAutoBindForceResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_TRIPOD_SN_AUTO_BIND_FORCE;
        this.mNetworkStatus = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotTripodSnAutoBoundResponseParam extends BLResponseBase implements Serializable {
    public int data = 0;

    public GWsTserviceIotTripodSnAutoBoundResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_TRIPOD_SN_AUTO_BOUND;
        this.mNetworkStatus = 0;
    }
}

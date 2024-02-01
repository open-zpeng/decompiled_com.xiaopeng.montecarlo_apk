package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotTripodStatusResponseParam extends BLResponseBase implements Serializable {
    public String data = "";
    public WsTserviceIotTripodStatusData data_value = new WsTserviceIotTripodStatusData();

    public GWsTserviceIotTripodStatusResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_TRIPOD_STATUS;
        this.mNetworkStatus = 0;
    }
}

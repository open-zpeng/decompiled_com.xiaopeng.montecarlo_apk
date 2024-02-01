package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceDatainterflowGetResponseParam extends BLResponseBase implements Serializable {
    public TServiceDatainterflowGetResponseData data = new TServiceDatainterflowGetResponseData();

    public GWsTserviceDatainterflowGetResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TSERVICE_DATAINTERFLOW_GET;
        this.mNetworkStatus = 0;
    }
}

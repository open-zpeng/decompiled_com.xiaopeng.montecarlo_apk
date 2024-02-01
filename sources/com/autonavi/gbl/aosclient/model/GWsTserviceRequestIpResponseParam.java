package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceRequestIpResponseParam extends BLResponseBase implements Serializable {
    public String data = "";

    public GWsTserviceRequestIpResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_REQUEST_IP;
        this.mNetworkStatus = 0;
    }
}

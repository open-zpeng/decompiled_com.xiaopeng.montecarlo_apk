package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GServerTimestampResponseParam extends BLResponseBase implements Serializable {
    public String timestamp = "";

    public GServerTimestampResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MAPAPI_SERVER_TIMESTAMP;
        this.mNetworkStatus = 0;
    }
}

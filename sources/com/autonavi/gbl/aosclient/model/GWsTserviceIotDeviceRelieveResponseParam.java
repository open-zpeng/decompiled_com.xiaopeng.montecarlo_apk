package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotDeviceRelieveResponseParam extends BLResponseBase implements Serializable {
    public String data = "";

    public GWsTserviceIotDeviceRelieveResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_DEVICE_RELIEVE;
        this.mNetworkStatus = 0;
    }
}

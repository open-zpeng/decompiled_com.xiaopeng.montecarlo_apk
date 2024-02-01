package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotDeviceRelieveRequestParam extends BLRequestBase implements Serializable {
    public String identity = "";
    public String uid = "";
    public String iotDeviceCode = "";
    public String sessionid = "";
    public String dip = "";

    public GWsTserviceIotDeviceRelieveRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_DEVICE_RELIEVE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

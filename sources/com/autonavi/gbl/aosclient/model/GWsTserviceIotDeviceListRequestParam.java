package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceIotDeviceListRequestParam extends BLRequestBase implements Serializable {
    public String uid = "";
    public String sessionid = "";
    public String dip = "";

    public GWsTserviceIotDeviceListRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_DEVICE_LIST;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

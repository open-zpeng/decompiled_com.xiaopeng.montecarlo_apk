package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GTripodCompanyResponseParam extends BLResponseBase implements Serializable {
    public String data = "";
    public IotTripodCompanyData data_value = new IotTripodCompanyData();

    public GTripodCompanyResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TSERVICE_IOT_TRIPOD_COMPANY;
        this.mNetworkStatus = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GTripodCompanyRequestParam extends BLRequestBase implements Serializable {
    public String sn = "";
    public String sessionid = "";

    public GTripodCompanyRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TSERVICE_IOT_TRIPOD_COMPANY;
        this.mEReqProtol = 0;
        this.mEReqMethod = 0;
    }
}

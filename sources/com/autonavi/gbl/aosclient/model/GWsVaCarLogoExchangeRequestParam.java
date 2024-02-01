package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsVaCarLogoExchangeRequestParam extends BLRequestBase implements Serializable {
    public String tid = "";
    public String logo_id = "";

    public GWsVaCarLogoExchangeRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_VA_CAR_LOGO_EXCHANGE;
        this.mEReqMethod = 1;
    }
}

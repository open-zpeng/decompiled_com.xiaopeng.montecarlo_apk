package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcFuelQueryagreementRequestParam extends BLRequestBase implements Serializable {
    public String payType = "";
    public String gw_userid = "";

    public GWsTcFuelQueryagreementRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_FUEL_QUERYAGREEMENT;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

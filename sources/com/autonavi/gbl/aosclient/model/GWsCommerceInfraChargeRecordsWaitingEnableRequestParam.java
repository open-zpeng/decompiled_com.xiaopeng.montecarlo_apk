package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsCommerceInfraChargeRecordsWaitingEnableRequestParam extends BLRequestBase implements Serializable {
    public String vid = "";
    public String pid = "";

    public GWsCommerceInfraChargeRecordsWaitingEnableRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_COMMERCE_INFRA_CHARGE_RECORDS_WAITING_ENABLE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

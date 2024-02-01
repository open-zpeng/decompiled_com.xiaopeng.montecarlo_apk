package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsCommerceInfraChargeRecordsWaitingEnableResponseParam extends BLResponseBase implements Serializable {
    public String code = "";
    public ChargeRecordsWaitingEnableResponseData data = new ChargeRecordsWaitingEnableResponseData();
    public String errdetail = "";
    public String message = "";
    public boolean result = false;
    public int timestamp = 0;
    public String version = "";

    public GWsCommerceInfraChargeRecordsWaitingEnableResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_COMMERCE_INFRA_CHARGE_RECORDS_WAITING_ENABLE;
        this.mNetworkStatus = 0;
    }
}

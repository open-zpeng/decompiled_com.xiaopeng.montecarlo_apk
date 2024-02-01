package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCommonAgreementStatusResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String timestamp = "";
    public String message = "";
    public String version = "";
    public WsTcCommonAgreementStatusResponseData data = new WsTcCommonAgreementStatusResponseData();
    public boolean success = false;

    public GWsTcCommonAgreementStatusResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_COMMON_AGREEMENT_STATUS;
        this.mNetworkStatus = 0;
    }
}

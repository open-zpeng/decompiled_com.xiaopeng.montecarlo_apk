package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCommonAgreementSignResponseParam extends BLResponseBase implements Serializable {
    public WsTcCommonAgreementSignResponseData data = new WsTcCommonAgreementSignResponseData();
    public boolean success = false;

    public GWsTcCommonAgreementSignResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_COMMON_AGREEMENT_SIGN;
        this.mNetworkStatus = 0;
    }
}

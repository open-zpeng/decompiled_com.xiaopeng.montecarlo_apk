package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCommonAgreementOrderquickpayResponseParam extends BLResponseBase implements Serializable {
    public WsTcCommonAgreementOrderQuickPayResponseData data = new WsTcCommonAgreementOrderQuickPayResponseData();
    public boolean success = false;

    public GWsTcCommonAgreementOrderquickpayResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_COMMON_AGREEMENT_ORDERQUICKPAY;
        this.mNetworkStatus = 0;
    }
}

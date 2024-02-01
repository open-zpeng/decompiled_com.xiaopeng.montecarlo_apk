package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCommonAgreementOrderquickpayRequestParam extends BLRequestBase implements Serializable {
    public String uid = "";
    public String phone = "";
    public WsTcCommonAgreementOrderQuickPayRequestData data = new WsTcCommonAgreementOrderQuickPayRequestData();

    public GWsTcCommonAgreementOrderquickpayRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_COMMON_AGREEMENT_ORDERQUICKPAY;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

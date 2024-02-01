package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCommonAgreementSignRequestParam extends BLRequestBase implements Serializable {
    public String uid = "";
    public String phone = "";
    public WsTcCommonAgreementSignRequestData data = new WsTcCommonAgreementSignRequestData();

    public GWsTcCommonAgreementSignRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_COMMON_AGREEMENT_SIGN;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

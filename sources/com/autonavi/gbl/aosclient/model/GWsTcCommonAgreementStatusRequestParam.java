package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCommonAgreementStatusRequestParam extends BLRequestBase implements Serializable {
    public WsTcCommonAgreementStatusRequestData data = new WsTcCommonAgreementStatusRequestData();
    public String uid = "";

    public GWsTcCommonAgreementStatusRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_COMMON_AGREEMENT_STATUS;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

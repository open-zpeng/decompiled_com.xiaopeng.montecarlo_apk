package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAccountDeactivateRequestParam extends BLRequestBase implements Serializable {
    public String mobile = "";
    public String code = "";

    public GWsPpAccountDeactivateRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_PP_ACCOUNT_DEACTIVATE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

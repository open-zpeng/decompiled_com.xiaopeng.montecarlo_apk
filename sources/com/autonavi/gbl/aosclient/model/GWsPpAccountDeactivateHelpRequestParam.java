package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAccountDeactivateHelpRequestParam extends BLRequestBase implements Serializable {
    public String adiu = "";

    public GWsPpAccountDeactivateHelpRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_PP_ACCOUNT_DEACTIVATE_HELP;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpContactUnbindMobileRequestParam extends BLRequestBase implements Serializable {
    public String check = "";

    public GWsPpContactUnbindMobileRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_PP_CONTACT_UNBIND_MOBILE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

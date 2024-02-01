package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpContactBindMobileRequestParam extends BLRequestBase implements Serializable {
    public String mobile = "";
    public String code = "";
    public int replace_type = 0;

    public GWsPpContactBindMobileRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_PP_CONTACT_BIND_MOBILE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpContactUnbindMobileResponseParam extends BLResponseBase implements Serializable {
    public String errmsg = "";
    public String err_order_id = "";
    public WsPpContactUnbindDataOrderConf order_conf = new WsPpContactUnbindDataOrderConf();

    public GWsPpContactUnbindMobileResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_PP_CONTACT_UNBIND_MOBILE;
        this.mNetworkStatus = 0;
    }
}

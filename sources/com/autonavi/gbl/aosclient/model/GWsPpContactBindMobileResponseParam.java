package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpContactBindMobileResponseParam extends BLResponseBase implements Serializable {
    public String credit = "";
    public String remain = "";
    public String errmsg = "";
    public String err_order_id = "";
    public DataUserProfile profile = new DataUserProfile();
    public DataOrderConf order_conf = new DataOrderConf();

    public GWsPpContactBindMobileResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_PP_CONTACT_BIND_MOBILE;
        this.mNetworkStatus = 0;
    }
}

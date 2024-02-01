package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAccountDeactivateResponseParam extends BLResponseBase implements Serializable {
    public WsPpAccountDeactivateData data = new WsPpAccountDeactivateData();

    public GWsPpAccountDeactivateResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_PP_ACCOUNT_DEACTIVATE;
        this.mNetworkStatus = 0;
    }
}

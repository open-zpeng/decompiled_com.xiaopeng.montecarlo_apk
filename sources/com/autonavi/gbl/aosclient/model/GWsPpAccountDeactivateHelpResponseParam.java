package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAccountDeactivateHelpResponseParam extends BLResponseBase implements Serializable {
    public WsPpAccountDeactivateHelpData data = new WsPpAccountDeactivateHelpData();

    public GWsPpAccountDeactivateHelpResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_PP_ACCOUNT_DEACTIVATE_HELP;
        this.mNetworkStatus = 0;
    }
}

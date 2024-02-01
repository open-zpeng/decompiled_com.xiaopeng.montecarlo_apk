package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldAsbpApiUploadResponseParam extends BLResponseBase implements Serializable {
    public boolean data = false;

    public GWsShieldAsbpApiUploadResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_ASBP_API_UPLOAD;
        this.mNetworkStatus = 0;
    }
}

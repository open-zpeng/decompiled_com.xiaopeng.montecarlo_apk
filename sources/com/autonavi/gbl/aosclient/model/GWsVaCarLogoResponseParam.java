package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsVaCarLogoResponseParam extends BLResponseBase implements Serializable {
    public WsVaCarLogoResponseData data = new WsVaCarLogoResponseData();

    public GWsVaCarLogoResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_VA_CAR_LOGO;
        this.mNetworkStatus = 0;
    }
}

package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsVaCarLogoSelectResponseParam extends BLResponseBase implements Serializable {
    public RecommendLogoListItem data = new RecommendLogoListItem();

    public GWsVaCarLogoSelectResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_VA_CAR_LOGO_SELECT;
        this.mNetworkStatus = 0;
    }
}

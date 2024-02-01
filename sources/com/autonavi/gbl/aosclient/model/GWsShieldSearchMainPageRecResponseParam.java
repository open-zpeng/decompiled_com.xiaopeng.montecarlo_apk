package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldSearchMainPageRecResponseParam extends BLResponseBase implements Serializable {
    public ScenicMainPageRecData data = new ScenicMainPageRecData();

    public GWsShieldSearchMainPageRecResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_MAIN_PAGE_REC;
        this.mNetworkStatus = 0;
    }
}

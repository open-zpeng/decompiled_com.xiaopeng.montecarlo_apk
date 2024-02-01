package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsNavigationDynamicFatigueResponseParam extends BLResponseBase implements Serializable {
    public String code = "";
    public String message = "";
    public String result = "";
    public String timestamp = "";
    public String version = "";

    public GWsNavigationDynamicFatigueResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_NAVIGATION_DYNAMIC_FATIGUE;
        this.mNetworkStatus = 0;
    }
}

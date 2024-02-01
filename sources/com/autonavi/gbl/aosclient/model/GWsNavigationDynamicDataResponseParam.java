package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsNavigationDynamicDataResponseParam extends BLResponseBase implements Serializable {
    public String result = "";
    public String code = "";
    public WsNavigationDynamicDataData data = new WsNavigationDynamicDataData();
    public String message = "";
    public String _class = "";
    public String version = "";
    public String timestamp = "";

    public GWsNavigationDynamicDataResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_NAVIGATION_DYNAMIC_DATA;
        this.mNetworkStatus = 0;
    }
}

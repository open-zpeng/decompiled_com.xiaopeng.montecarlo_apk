package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldSearchRanklistPortalResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String message = "";
    public WsShieldSearchRanklistPortalResponseData data = new WsShieldSearchRanklistPortalResponseData();

    public GWsShieldSearchRanklistPortalResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_RANKLIST_PORTAL;
        this.mNetworkStatus = 0;
    }
}

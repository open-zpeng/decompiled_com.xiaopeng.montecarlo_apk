package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldSearchRanklistLandingResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String message = "";
    public WsShieldSearchRanklist_landingResponseData data = new WsShieldSearchRanklist_landingResponseData();

    public GWsShieldSearchRanklistLandingResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_RANKLIST_LANDING;
        this.mNetworkStatus = 0;
    }
}

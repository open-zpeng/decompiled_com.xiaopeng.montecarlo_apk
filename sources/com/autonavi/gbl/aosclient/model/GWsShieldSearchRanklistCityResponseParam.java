package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldSearchRanklistCityResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String message = "";
    public WsShieldSearchRanklistCityResponseData data = new WsShieldSearchRanklistCityResponseData();

    public GWsShieldSearchRanklistCityResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_RANKLIST_CITY;
        this.mNetworkStatus = 0;
    }
}

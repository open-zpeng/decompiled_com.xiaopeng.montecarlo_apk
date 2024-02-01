package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsEventSearchResponseParam extends BLResponseBase implements Serializable {
    public WsEventSearchData data = new WsEventSearchData();

    public GWsEventSearchResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5__WS_CUSTOM1_EVENT_SEARCH;
        this.mNetworkStatus = 0;
    }
}

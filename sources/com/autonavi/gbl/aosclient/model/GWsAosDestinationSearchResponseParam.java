package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAosDestinationSearchResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public WsAosDestinationSearchResponseData data = new WsAosDestinationSearchResponseData();
    public boolean success = false;
    public String message = "";
    public double timestamp = 0.0d;

    public GWsAosDestinationSearchResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_AOS_DESTINATION_SEARCH;
        this.mNetworkStatus = 0;
    }
}

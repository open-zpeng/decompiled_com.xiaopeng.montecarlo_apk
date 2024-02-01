package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAosDestinationSearchRequestParam extends BLRequestBase implements Serializable {
    public String lon = "";
    public String lat = "";
    public String keywords = "";
    public String frompage = "";
    public String poiId = "";

    public GWsAosDestinationSearchRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_AOS_DESTINATION_SEARCH;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}

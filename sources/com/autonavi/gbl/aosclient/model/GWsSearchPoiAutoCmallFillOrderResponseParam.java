package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsSearchPoiAutoCmallFillOrderResponseParam extends BLResponseBase implements Serializable {
    public WsSearchPoiAutoCmallFillOrderResponseData data = new WsSearchPoiAutoCmallFillOrderResponseData();

    public GWsSearchPoiAutoCmallFillOrderResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SEARCH_POI_AUTO_CMALL_FILL_ORDER;
        this.mNetworkStatus = 0;
    }
}

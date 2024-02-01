package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsUserviewFootprintSummaryResponseParam extends BLResponseBase implements Serializable {
    public WsUserviewFootprintSummaryAckData data = new WsUserviewFootprintSummaryAckData();

    public GWsUserviewFootprintSummaryResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_USERVIEW_FOOTPRINT_SUMMARY;
        this.mNetworkStatus = 0;
    }
}

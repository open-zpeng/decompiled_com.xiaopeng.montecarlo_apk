package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsUserviewFootprintNaviRecordResponseParam extends BLResponseBase implements Serializable {
    public WsUserviewFootprintNaviRecordData data = new WsUserviewFootprintNaviRecordData();

    public GWsUserviewFootprintNaviRecordResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_USERVIEW_FOOTPRINT_NAVI_RECORD;
        this.mNetworkStatus = 0;
    }
}

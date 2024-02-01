package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsUserviewFootprintNaviDeleteResponseParam extends BLResponseBase implements Serializable {
    public WsUserviewFootprintNaviDeleteData data = new WsUserviewFootprintNaviDeleteData();

    public GWsUserviewFootprintNaviDeleteResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_USERVIEW_FOOTPRINT_NAVI_DELETE;
        this.mNetworkStatus = 0;
    }
}

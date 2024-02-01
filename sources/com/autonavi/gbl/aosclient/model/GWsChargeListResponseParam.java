package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsChargeListResponseParam extends BLResponseBase implements Serializable {
    public WsChargeListData data = new WsChargeListData();
    public String errdetail = "";

    public GWsChargeListResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_CUSTOM1_CHARGE_LIST;
        this.mNetworkStatus = 0;
    }
}

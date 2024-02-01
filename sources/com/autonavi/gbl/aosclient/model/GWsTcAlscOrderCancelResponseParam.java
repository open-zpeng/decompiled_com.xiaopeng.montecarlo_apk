package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcAlscOrderCancelResponseParam extends BLResponseBase implements Serializable {
    public WsTcAlscOrderCancelResponseData data = new WsTcAlscOrderCancelResponseData();

    public GWsTcAlscOrderCancelResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_ALSC_ORDER_CANCEL;
        this.mNetworkStatus = 0;
    }
}

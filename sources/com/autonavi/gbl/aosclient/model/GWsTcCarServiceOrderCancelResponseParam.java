package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCarServiceOrderCancelResponseParam extends BLResponseBase implements Serializable {
    public boolean data = false;

    public GWsTcCarServiceOrderCancelResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_CAR_SERVICE_ORDER_CANCEL;
        this.mNetworkStatus = 0;
    }
}

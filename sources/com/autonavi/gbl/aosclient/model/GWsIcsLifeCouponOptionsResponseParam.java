package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsIcsLifeCouponOptionsResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String timestamp = "";
    public String version = "";
    public String result = "";
    public String message = "";
    public WsIcsLifeCouponOptionsResponseData data = new WsIcsLifeCouponOptionsResponseData();

    public GWsIcsLifeCouponOptionsResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_ICS_LIFE_COUPON_OPTIONS;
        this.mNetworkStatus = 0;
    }
}

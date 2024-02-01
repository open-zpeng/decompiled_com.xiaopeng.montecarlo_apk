package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsIcsLifeUserCouponListResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String timestamp = "";
    public String version = "";
    public String result = "";
    public String message = "";
    public WsIcsLifeUserCouponListResponseData data = new WsIcsLifeUserCouponListResponseData();

    public GWsIcsLifeUserCouponListResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_ICS_LIFE_USER_COUPON_LIST;
        this.mNetworkStatus = 0;
    }
}

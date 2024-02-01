package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCouponrecvlistRequestParam extends BLRequestBase implements Serializable {
    public long ts = 0;
    public int scene = 0;
    public String adcode = "";
    public String typeCode = "";
    public String userFlag = "";
    public String poiId = "";
    public String bizParams = "";
    public String userId = "";
    public int user_adcode = -1;

    public GCouponrecvlistRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_ICS_LIFE_COUPON_RECV_LIST;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

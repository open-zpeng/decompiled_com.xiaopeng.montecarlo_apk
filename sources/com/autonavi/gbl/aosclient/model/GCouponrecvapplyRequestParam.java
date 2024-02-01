package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCouponrecvapplyRequestParam extends BLRequestBase implements Serializable {
    public long ts = 0;
    public int scene = 0;
    public String couponIds = "";
    public String uid = "";

    public GCouponrecvapplyRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_ICS_LIFE_COUPON_RECV_APPLY;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

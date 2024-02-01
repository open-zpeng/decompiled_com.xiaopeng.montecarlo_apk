package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsIcsLifeCouponOptionsRequestParam extends BLRequestBase implements Serializable {
    public long ts = 0;
    public int amount = 0;
    public int typeCode = 0;
    public String poiId = "";
    public String cp = "";
    public String uid = "";

    public GWsIcsLifeCouponOptionsRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_ICS_LIFE_COUPON_OPTIONS;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

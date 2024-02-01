package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsIcsLifeUserCouponListRequestParam extends BLRequestBase implements Serializable {
    public long ts = 0;
    public long uid = 0;
    public int queryStatus = 0;
    public String cp = "";
    public int bizType = 0;
    public int pageNum = 0;
    public int pageSize = 0;
    public String phone = "";

    public GWsIcsLifeUserCouponListRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_ICS_LIFE_USER_COUPON_LIST;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}

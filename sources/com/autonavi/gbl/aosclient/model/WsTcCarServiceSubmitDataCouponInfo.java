package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCarServiceSubmitDataCouponInfo implements Serializable {
    public String amount;
    public String couponId;
    public String recordId;

    public WsTcCarServiceSubmitDataCouponInfo() {
        this.recordId = "";
        this.couponId = "";
        this.amount = "";
    }

    public WsTcCarServiceSubmitDataCouponInfo(String str, String str2, String str3) {
        this.recordId = str;
        this.couponId = str2;
        this.amount = str3;
    }
}

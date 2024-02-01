package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsIcsLifeCouponRecvListResponseData implements Serializable {
    public ArrayList<WsIcsLifeCouponRecvListDataCouponList> couponList;

    public WsIcsLifeCouponRecvListResponseData() {
        this.couponList = new ArrayList<>();
    }

    public WsIcsLifeCouponRecvListResponseData(ArrayList<WsIcsLifeCouponRecvListDataCouponList> arrayList) {
        this.couponList = arrayList;
    }
}

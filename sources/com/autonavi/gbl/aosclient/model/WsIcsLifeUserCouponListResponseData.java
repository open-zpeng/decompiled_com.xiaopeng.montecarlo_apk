package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsIcsLifeUserCouponListResponseData implements Serializable {
    public ArrayList<WsIcsLifeUserCouponListDataItem> items;

    public WsIcsLifeUserCouponListResponseData() {
        this.items = new ArrayList<>();
    }

    public WsIcsLifeUserCouponListResponseData(ArrayList<WsIcsLifeUserCouponListDataItem> arrayList) {
        this.items = arrayList;
    }
}

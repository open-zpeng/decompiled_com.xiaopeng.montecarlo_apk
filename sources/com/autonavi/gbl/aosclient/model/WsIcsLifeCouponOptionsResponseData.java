package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsIcsLifeCouponOptionsResponseData implements Serializable {
    public ArrayList<WsIcsLifeCouponOptionsDataUnUseful> unUseful;
    public ArrayList<WsIcsLifeCouponOptionsDataUseful> useful;

    public WsIcsLifeCouponOptionsResponseData() {
        this.useful = new ArrayList<>();
        this.unUseful = new ArrayList<>();
    }

    public WsIcsLifeCouponOptionsResponseData(ArrayList<WsIcsLifeCouponOptionsDataUseful> arrayList, ArrayList<WsIcsLifeCouponOptionsDataUnUseful> arrayList2) {
        this.useful = arrayList;
        this.unUseful = arrayList2;
    }
}

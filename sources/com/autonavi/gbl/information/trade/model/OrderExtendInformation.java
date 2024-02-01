package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OrderExtendInformation implements Serializable {
    public GoodExtendInformation goodExtend;
    public ArrayList<CancelTradeReason> reasons;

    public OrderExtendInformation() {
        this.reasons = new ArrayList<>();
        this.goodExtend = new GoodExtendInformation();
    }

    public OrderExtendInformation(ArrayList<CancelTradeReason> arrayList, GoodExtendInformation goodExtendInformation) {
        this.reasons = arrayList;
        this.goodExtend = goodExtendInformation;
    }
}

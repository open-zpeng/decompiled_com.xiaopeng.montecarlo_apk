package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FuelOrderCancelRequest extends OrderCancelRequest implements Serializable {
    public ArrayList<String> orderIds = new ArrayList<>();

    public FuelOrderCancelRequest() {
        this.bizType = 1;
    }
}

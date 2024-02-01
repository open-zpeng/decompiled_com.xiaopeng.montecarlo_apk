package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FuelOrderCancelResult extends OrderCancelResult implements Serializable {
    public ArrayList<String> orderIds = new ArrayList<>();

    public FuelOrderCancelResult() {
        this.bizType = 1;
    }
}

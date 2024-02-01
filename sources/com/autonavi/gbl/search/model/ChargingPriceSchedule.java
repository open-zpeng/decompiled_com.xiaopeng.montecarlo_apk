package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ChargingPriceSchedule implements Serializable {
    public ArrayList<ChargingPeriodPrice> chargingPeriodPrices;
    public String srcType;

    public ChargingPriceSchedule() {
        this.chargingPeriodPrices = new ArrayList<>();
        this.srcType = "";
    }

    public ChargingPriceSchedule(ArrayList<ChargingPeriodPrice> arrayList, String str) {
        this.chargingPeriodPrices = arrayList;
        this.srcType = str;
    }
}

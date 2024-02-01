package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ElecCustomization implements Serializable {
    public ArrayList<String> blackList;
    public ChargingArguments chargingArg;
    public ConsumptionArguments consumptionArg;
    public ChargerPlugsInfo plugsInfo;

    public ElecCustomization() {
        this.consumptionArg = new ConsumptionArguments();
        this.chargingArg = new ChargingArguments();
        this.plugsInfo = new ChargerPlugsInfo();
        this.blackList = new ArrayList<>();
    }

    public ElecCustomization(ConsumptionArguments consumptionArguments, ChargingArguments chargingArguments, ChargerPlugsInfo chargerPlugsInfo, ArrayList<String> arrayList) {
        this.consumptionArg = consumptionArguments;
        this.chargingArg = chargingArguments;
        this.plugsInfo = chargerPlugsInfo;
        this.blackList = arrayList;
    }
}

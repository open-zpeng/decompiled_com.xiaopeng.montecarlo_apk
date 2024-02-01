package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiChargingStationInfo extends ChargingStationInfo implements Serializable {
    public ArrayList<Integer> rights = new ArrayList<>();
    public ArrayList<SearchChargeProvider> chargeProviders = new ArrayList<>();
    public String parkPrice = "";
    public long latestChargeTimestamp = -1;
    public long searchTimestamp = -1;
}

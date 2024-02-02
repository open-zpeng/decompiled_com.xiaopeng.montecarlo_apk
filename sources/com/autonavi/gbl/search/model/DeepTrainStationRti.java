package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DeepTrainStationRti implements Serializable {
    public ArrayList<DeepStationEntranceInfo> stationEntranceInfo;
    public ArrayList<DeepStationPoisList> stationPoisList;

    public DeepTrainStationRti() {
        this.stationPoisList = new ArrayList<>();
        this.stationEntranceInfo = new ArrayList<>();
    }

    public DeepTrainStationRti(ArrayList<DeepStationPoisList> arrayList, ArrayList<DeepStationEntranceInfo> arrayList2) {
        this.stationPoisList = arrayList;
        this.stationEntranceInfo = arrayList2;
    }
}

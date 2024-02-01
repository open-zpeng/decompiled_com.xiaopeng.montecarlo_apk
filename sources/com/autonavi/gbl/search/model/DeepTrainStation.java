package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DeepTrainStation implements Serializable {
    public DeepTrainStationRti dynInfo;

    public DeepTrainStation() {
        this.dynInfo = new DeepTrainStationRti();
    }

    public DeepTrainStation(DeepTrainStationRti deepTrainStationRti) {
        this.dynInfo = deepTrainStationRti;
    }
}

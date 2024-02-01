package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CruisePredictiveLaneInfo implements Serializable {
    public ArrayList<CruisePredictiveLane> laneList;

    public CruisePredictiveLaneInfo() {
        this.laneList = new ArrayList<>();
    }

    public CruisePredictiveLaneInfo(ArrayList<CruisePredictiveLane> arrayList) {
        this.laneList = arrayList;
    }
}

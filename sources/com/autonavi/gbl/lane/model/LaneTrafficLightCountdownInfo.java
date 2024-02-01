package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LaneTrafficLightCountdownInfo implements Serializable {
    public ArrayList<LaneTrafficLightCountdown> countdownList;

    public LaneTrafficLightCountdownInfo() {
        this.countdownList = new ArrayList<>();
    }

    public LaneTrafficLightCountdownInfo(ArrayList<LaneTrafficLightCountdown> arrayList) {
        this.countdownList = arrayList;
    }
}

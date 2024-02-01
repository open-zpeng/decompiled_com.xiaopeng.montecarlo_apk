package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CruisePredictive implements Serializable {
    public long laneDistance;

    public CruisePredictive() {
        this.laneDistance = 200L;
    }

    public CruisePredictive(long j) {
        this.laneDistance = j;
    }
}

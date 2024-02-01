package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneLndsBreakOffType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneLndsDataDistance implements Serializable {
    public float breakOffDistance;
    @LaneLndsBreakOffType.LaneLndsBreakOffType1
    public int breakOffType;
    public float distance;

    public LaneLndsDataDistance() {
        this.distance = 0.0f;
        this.breakOffType = 0;
        this.breakOffDistance = 0.0f;
    }

    public LaneLndsDataDistance(float f, @LaneLndsBreakOffType.LaneLndsBreakOffType1 int i, float f2) {
        this.distance = f;
        this.breakOffType = i;
        this.breakOffDistance = f2;
    }
}

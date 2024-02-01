package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.RoadLaneType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneNaviInfo implements Serializable {
    public boolean isViolation;
    @RoadLaneType.RoadLaneType1
    public int laneType;
    public long pathID;
    public float speed;

    public LaneNaviInfo() {
        this.pathID = 0L;
        this.laneType = 0;
        this.isViolation = false;
        this.speed = 0.0f;
    }

    public LaneNaviInfo(long j, @RoadLaneType.RoadLaneType1 int i, boolean z, float f) {
        this.pathID = j;
        this.laneType = i;
        this.isViolation = z;
        this.speed = f;
    }
}

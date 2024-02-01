package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneChangeStatus;
import com.autonavi.gbl.lane.model.RelativeDirection;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SimplifiedDecision implements Serializable {
    @LaneChangeStatus.LaneChangeStatus1
    public int changeStatus;
    @RelativeDirection.RelativeDirection1
    public int direction;
    public DrivingLaneHighlightInfo drivingHighlight;

    public SimplifiedDecision() {
        this.changeStatus = 0;
        this.direction = 99;
        this.drivingHighlight = new DrivingLaneHighlightInfo();
    }

    public SimplifiedDecision(@LaneChangeStatus.LaneChangeStatus1 int i, @RelativeDirection.RelativeDirection1 int i2, DrivingLaneHighlightInfo drivingLaneHighlightInfo) {
        this.changeStatus = i;
        this.direction = i2;
        this.drivingHighlight = drivingLaneHighlightInfo;
    }
}

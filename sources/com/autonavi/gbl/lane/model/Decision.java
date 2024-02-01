package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneChangeStatus;
import com.autonavi.gbl.lane.model.RelativeDirection;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Decision implements Serializable {
    @LaneChangeStatus.LaneChangeStatus1
    public int changeStatus;
    public ArrayList<RelativePos> coords;
    @RelativeDirection.RelativeDirection1
    public int direction;
    public DrivingLaneHighlightInfo drivingHighlight;
    public boolean isUseRotation;
    public RelativePos localRefPos;
    public LanePosRotation rotation;

    public Decision() {
        this.coords = new ArrayList<>();
        this.localRefPos = new RelativePos();
        this.isUseRotation = false;
        this.rotation = new LanePosRotation();
        this.changeStatus = 0;
        this.direction = 99;
        this.drivingHighlight = new DrivingLaneHighlightInfo();
    }

    public Decision(ArrayList<RelativePos> arrayList, RelativePos relativePos, boolean z, LanePosRotation lanePosRotation, @LaneChangeStatus.LaneChangeStatus1 int i, @RelativeDirection.RelativeDirection1 int i2, DrivingLaneHighlightInfo drivingLaneHighlightInfo) {
        this.coords = arrayList;
        this.localRefPos = relativePos;
        this.isUseRotation = z;
        this.rotation = lanePosRotation;
        this.changeStatus = i;
        this.direction = i2;
        this.drivingHighlight = drivingLaneHighlightInfo;
    }
}

package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LANE_CHANGE_STATUS;
import com.autonavi.gbl.lane.model.RELATIVE_DIRECTION;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Decision implements Serializable {
    @LANE_CHANGE_STATUS.LANE_CHANGE_STATUS1
    public int changeStatus;
    public ArrayList<RelativePos> coords;
    @RELATIVE_DIRECTION.RELATIVE_DIRECTION1
    public int direction;
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
    }

    public Decision(ArrayList<RelativePos> arrayList, RelativePos relativePos, boolean z, LanePosRotation lanePosRotation, @LANE_CHANGE_STATUS.LANE_CHANGE_STATUS1 int i, @RELATIVE_DIRECTION.RELATIVE_DIRECTION1 int i2) {
        this.coords = arrayList;
        this.localRefPos = relativePos;
        this.isUseRotation = z;
        this.rotation = lanePosRotation;
        this.changeStatus = i;
        this.direction = i2;
    }
}

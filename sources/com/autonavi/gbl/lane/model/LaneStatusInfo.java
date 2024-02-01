package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneStatusDescription;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneStatusInfo implements Serializable {
    public boolean enter;
    @LaneStatusDescription.LaneStatusDescription1
    public int status;

    public LaneStatusInfo() {
        this.enter = false;
        this.status = -1;
    }

    public LaneStatusInfo(boolean z, @LaneStatusDescription.LaneStatusDescription1 int i) {
        this.enter = z;
        this.status = i;
    }
}

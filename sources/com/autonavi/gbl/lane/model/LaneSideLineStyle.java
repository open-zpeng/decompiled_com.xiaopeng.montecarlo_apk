package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneSideLineDirection;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneSideLineStyle implements Serializable {
    @LaneSideLineDirection.LaneSideLineDirection1
    public int direction;
    public LaneLineStyleInfo lineStyle;

    public LaneSideLineStyle() {
        this.direction = 0;
        this.lineStyle = new LaneLineStyleInfo();
    }

    public LaneSideLineStyle(@LaneSideLineDirection.LaneSideLineDirection1 int i, LaneLineStyleInfo laneLineStyleInfo) {
        this.direction = i;
        this.lineStyle = laneLineStyleInfo;
    }
}

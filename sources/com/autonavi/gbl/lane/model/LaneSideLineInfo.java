package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneSideLineAnimationStatus;
import com.autonavi.gbl.lane.model.LaneSideLineDirection;
import com.autonavi.gbl.lane.model.LaneSideLineStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneSideLineInfo implements Serializable {
    @LaneSideLineAnimationStatus.LaneSideLineAnimationStatus1
    public int animationStatus;
    @LaneSideLineDirection.LaneSideLineDirection1
    public int direction;
    @LaneSideLineStatus.LaneSideLineStatus1
    public int status;

    public LaneSideLineInfo() {
        this.status = 1;
        this.direction = 0;
        this.animationStatus = 0;
    }

    public LaneSideLineInfo(@LaneSideLineStatus.LaneSideLineStatus1 int i, @LaneSideLineDirection.LaneSideLineDirection1 int i2, @LaneSideLineAnimationStatus.LaneSideLineAnimationStatus1 int i3) {
        this.status = i;
        this.direction = i2;
        this.animationStatus = i3;
    }
}

package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.ELaneResState;
/* loaded from: classes2.dex */
public class LaneResIndicator {
    public long exceptReason;
    public boolean isInHDArea;
    @ELaneResState.ELaneResState1
    public int state;

    public LaneResIndicator() {
        this.isInHDArea = false;
        this.state = 0;
        this.exceptReason = 0L;
    }

    public LaneResIndicator(boolean z, @ELaneResState.ELaneResState1 int i, long j) {
        this.isInHDArea = z;
        this.state = i;
        this.exceptReason = j;
    }
}

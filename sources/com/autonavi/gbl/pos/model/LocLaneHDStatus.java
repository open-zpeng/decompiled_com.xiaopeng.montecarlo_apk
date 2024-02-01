package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocLaneHDStatus implements Serializable {
    public boolean isLaneHDEnable;

    public LocLaneHDStatus() {
        this.isLaneHDEnable = false;
    }

    public LocLaneHDStatus(boolean z) {
        this.isLaneHDEnable = z;
    }
}

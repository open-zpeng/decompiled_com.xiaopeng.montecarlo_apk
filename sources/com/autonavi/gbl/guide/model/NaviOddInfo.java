package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviOddInfo implements Serializable {
    public long oddIdx;
    public float offSet;
    public long pathID;
    public long pointIdx;
    public boolean simulate;
    public boolean valid;

    public NaviOddInfo() {
        this.valid = false;
        this.simulate = false;
        this.pathID = 0L;
        this.oddIdx = 0L;
        this.pointIdx = 0L;
        this.offSet = -1.0f;
    }

    public NaviOddInfo(boolean z, boolean z2, long j, long j2, long j3, float f) {
        this.valid = z;
        this.simulate = z2;
        this.pathID = j;
        this.oddIdx = j2;
        this.pointIdx = j3;
        this.offSet = f;
    }
}

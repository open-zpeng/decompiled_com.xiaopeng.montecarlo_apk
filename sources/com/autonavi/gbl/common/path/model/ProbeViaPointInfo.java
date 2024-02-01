package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ProbeViaPointInfo implements Serializable {
    public int linkIndex;
    public int pointIndex;

    public ProbeViaPointInfo() {
        this.pointIndex = 0;
        this.linkIndex = 0;
    }

    public ProbeViaPointInfo(int i, int i2) {
        this.pointIndex = i;
        this.linkIndex = i2;
    }
}

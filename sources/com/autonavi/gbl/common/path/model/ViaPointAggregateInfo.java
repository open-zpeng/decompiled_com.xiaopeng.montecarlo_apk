package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ViaPointAggregateInfo implements Serializable {
    public long adCode;
    public int linkIdx;
    public int pointIdx;
    public int reserved;
    public int segIdx;

    public ViaPointAggregateInfo() {
        this.adCode = 0L;
        this.segIdx = 0;
        this.linkIdx = 0;
        this.pointIdx = 0;
        this.reserved = 0;
    }

    public ViaPointAggregateInfo(long j, int i, int i2, int i3, int i4) {
        this.adCode = j;
        this.segIdx = i;
        this.linkIdx = i2;
        this.pointIdx = i3;
        this.reserved = i4;
    }
}

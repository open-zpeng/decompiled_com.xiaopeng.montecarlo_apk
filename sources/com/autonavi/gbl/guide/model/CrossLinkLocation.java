package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CrossLinkLocation implements Serializable {
    public long linkIndex;
    public long segmentIndex;

    public CrossLinkLocation() {
        this.segmentIndex = 0L;
        this.linkIndex = 0L;
    }

    public CrossLinkLocation(long j, long j2) {
        this.segmentIndex = j;
        this.linkIndex = j2;
    }
}

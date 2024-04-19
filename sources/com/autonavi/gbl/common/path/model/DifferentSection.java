package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DifferentSection implements Serializable {
    public long endLinkIndex;
    public long pathID;
    public long startLinkIndex;

    public DifferentSection() {
        this.pathID = 0L;
        this.startLinkIndex = 0L;
        this.endLinkIndex = 0L;
    }

    public DifferentSection(long j, long j2, long j3) {
        this.pathID = j;
        this.startLinkIndex = j2;
        this.endLinkIndex = j3;
    }
}

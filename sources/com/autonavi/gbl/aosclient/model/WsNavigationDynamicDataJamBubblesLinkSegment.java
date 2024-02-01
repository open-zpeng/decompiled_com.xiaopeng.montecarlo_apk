package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataJamBubblesLinkSegment implements Serializable {
    public int endDistance;
    public long endRoadId;
    public int startDistance;
    public long startRoadId;

    public WsNavigationDynamicDataJamBubblesLinkSegment() {
        this.startRoadId = 0L;
        this.endRoadId = 0L;
        this.startDistance = 0;
        this.endDistance = 0;
    }

    public WsNavigationDynamicDataJamBubblesLinkSegment(long j, long j2, int i, int i2) {
        this.startRoadId = j;
        this.endRoadId = j2;
        this.startDistance = i;
        this.endDistance = i2;
    }
}

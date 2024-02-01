package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TrafficJamBubbles implements Serializable {
    public long pathId;
    public ArrayList<JamBubblesOfSegment> segments;

    public TrafficJamBubbles() {
        this.pathId = 0L;
        this.segments = new ArrayList<>();
    }

    public TrafficJamBubbles(long j, ArrayList<JamBubblesOfSegment> arrayList) {
        this.pathId = j;
        this.segments = arrayList;
    }
}

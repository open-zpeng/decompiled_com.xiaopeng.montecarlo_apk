package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.guide.model.TrafficEventInfo;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneTrafficEventInfo implements Serializable {
    public boolean exactMatch;
    public HDExtendInfo hdExtendInfo;
    public TrafficEventInfo sdTREvent;

    public LaneTrafficEventInfo() {
        this.sdTREvent = new TrafficEventInfo();
        this.hdExtendInfo = new HDExtendInfo();
        this.exactMatch = false;
    }

    public LaneTrafficEventInfo(TrafficEventInfo trafficEventInfo, HDExtendInfo hDExtendInfo, boolean z) {
        this.sdTREvent = trafficEventInfo;
        this.hdExtendInfo = hDExtendInfo;
        this.exactMatch = z;
    }
}

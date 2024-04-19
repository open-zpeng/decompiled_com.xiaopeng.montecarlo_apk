package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.guide.model.TrafficEventInfo;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneTrafficEventInfo implements Serializable {
    public HDExtendInfo leftHdExtendInfo;
    public HDExtendInfo rightHdExtendInfo;
    public TrafficEventInfo sdTREvent;

    public LaneTrafficEventInfo() {
        this.sdTREvent = new TrafficEventInfo();
        this.leftHdExtendInfo = new HDExtendInfo();
        this.rightHdExtendInfo = new HDExtendInfo();
    }

    public LaneTrafficEventInfo(TrafficEventInfo trafficEventInfo, HDExtendInfo hDExtendInfo, HDExtendInfo hDExtendInfo2) {
        this.sdTREvent = trafficEventInfo;
        this.leftHdExtendInfo = hDExtendInfo;
        this.rightHdExtendInfo = hDExtendInfo2;
    }
}

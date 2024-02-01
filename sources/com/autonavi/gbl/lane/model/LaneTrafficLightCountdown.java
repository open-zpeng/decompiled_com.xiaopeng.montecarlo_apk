package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.common.path.model.MainAction;
import com.autonavi.gbl.guide.model.TrafficLightCountdown;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneTrafficLightCountdown implements Serializable {
    public HDExtendInfo leftHdExtendInfo;
    public TrafficLightCountdown lightCountdown;
    @MainAction.MainAction1
    public int mainAction;
    public HDExtendInfo rightHdExtendInfo;

    public LaneTrafficLightCountdown() {
        this.lightCountdown = new TrafficLightCountdown();
        this.mainAction = 0;
        this.leftHdExtendInfo = new HDExtendInfo();
        this.rightHdExtendInfo = new HDExtendInfo();
    }

    public LaneTrafficLightCountdown(TrafficLightCountdown trafficLightCountdown, @MainAction.MainAction1 int i, HDExtendInfo hDExtendInfo, HDExtendInfo hDExtendInfo2) {
        this.lightCountdown = trafficLightCountdown;
        this.mainAction = i;
        this.leftHdExtendInfo = hDExtendInfo;
        this.rightHdExtendInfo = hDExtendInfo2;
    }
}

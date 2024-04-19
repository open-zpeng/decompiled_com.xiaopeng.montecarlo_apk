package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.guide.model.TrafficEventAction;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LanePathTrafficEventInfo implements Serializable {
    @TrafficEventAction.TrafficEventAction1
    public int action;
    public ArrayList<LaneTrafficEventInfo> eventInfoArray;
    public long pathID;

    public LanePathTrafficEventInfo() {
        this.eventInfoArray = new ArrayList<>();
        this.pathID = 0L;
        this.action = 1;
    }

    public LanePathTrafficEventInfo(ArrayList<LaneTrafficEventInfo> arrayList, long j, @TrafficEventAction.TrafficEventAction1 int i) {
        this.eventInfoArray = arrayList;
        this.pathID = j;
        this.action = i;
    }
}

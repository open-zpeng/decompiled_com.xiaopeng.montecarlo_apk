package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.guide.model.TrafficEventAction;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PathTrafficEventInfo implements Serializable {
    @TrafficEventAction.TrafficEventAction1
    public int action;
    public ArrayList<TrafficEventInfo> eventInfoArray;
    public long pathID;

    public PathTrafficEventInfo() {
        this.eventInfoArray = new ArrayList<>();
        this.pathID = 0L;
        this.action = 1;
    }

    public PathTrafficEventInfo(ArrayList<TrafficEventInfo> arrayList, long j, @TrafficEventAction.TrafficEventAction1 int i) {
        this.eventInfoArray = arrayList;
        this.pathID = j;
        this.action = i;
    }
}

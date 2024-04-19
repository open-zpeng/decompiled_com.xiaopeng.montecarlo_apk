package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.path.model.TrafficStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LightBarItem implements Serializable {
    public TrafficItem end3dTrafficItem;
    public long endLinkFineStatus;
    public int endLinkIndex;
    public long endLinkStatus;
    public int endSegmentIdx;
    public TrafficItem endTrafficItem;
    public int fineStatus;
    public int length;
    public TrafficItem start3dTrafficItem;
    public long startLinkFineStatus;
    public int startLinkIdx;
    public long startLinkStatus;
    public int startSegmentIdx;
    public TrafficItem startTrafficItem;
    @TrafficStatus.TrafficStatus1
    public int status;
    public short statusFlag;
    public long timeOfSeconds;

    public LightBarItem() {
        this.statusFlag = (short) 0;
        this.status = 0;
        this.fineStatus = 0;
        this.length = 0;
        this.timeOfSeconds = 0L;
        this.startSegmentIdx = 0;
        this.startLinkIdx = 0;
        this.startLinkStatus = 0L;
        this.startLinkFineStatus = 0L;
        this.endSegmentIdx = 0;
        this.endLinkIndex = 0;
        this.endLinkStatus = 0L;
        this.endLinkFineStatus = 0L;
        this.startTrafficItem = new TrafficItem();
        this.start3dTrafficItem = new TrafficItem();
        this.endTrafficItem = new TrafficItem();
        this.end3dTrafficItem = new TrafficItem();
    }

    public LightBarItem(short s, @TrafficStatus.TrafficStatus1 int i, int i2, int i3, long j, int i4, int i5, long j2, long j3, int i6, int i7, long j4, long j5, TrafficItem trafficItem, TrafficItem trafficItem2, TrafficItem trafficItem3, TrafficItem trafficItem4) {
        this.statusFlag = s;
        this.status = i;
        this.fineStatus = i2;
        this.length = i3;
        this.timeOfSeconds = j;
        this.startSegmentIdx = i4;
        this.startLinkIdx = i5;
        this.startLinkStatus = j2;
        this.startLinkFineStatus = j3;
        this.endSegmentIdx = i6;
        this.endLinkIndex = i7;
        this.endLinkStatus = j4;
        this.endLinkFineStatus = j5;
        this.startTrafficItem = trafficItem;
        this.start3dTrafficItem = trafficItem2;
        this.endTrafficItem = trafficItem3;
        this.end3dTrafficItem = trafficItem4;
    }
}

package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class IndoorParkingInfo implements Serializable {
    public ArrayList<ParkingCorridorInfo> corridorInfo;
    public long endLinkIndex;
    public long endSegmentIndex;
    public long startLinkIndex;
    public long startSegmentIndex;
    public short type;

    public IndoorParkingInfo() {
        this.type = (short) 0;
        this.startSegmentIndex = 0L;
        this.startLinkIndex = 0L;
        this.endSegmentIndex = 0L;
        this.endLinkIndex = 0L;
        this.corridorInfo = new ArrayList<>();
    }

    public IndoorParkingInfo(short s, long j, long j2, long j3, long j4, ArrayList<ParkingCorridorInfo> arrayList) {
        this.type = s;
        this.startSegmentIndex = j;
        this.startLinkIndex = j2;
        this.endSegmentIndex = j3;
        this.endLinkIndex = j4;
        this.corridorInfo = arrayList;
    }
}

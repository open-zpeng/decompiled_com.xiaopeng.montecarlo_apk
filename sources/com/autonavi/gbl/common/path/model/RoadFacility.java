package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.path.model.FacilityType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RoadFacility implements Serializable {
    public int distToEnd;
    public short laneNum;
    public int lat;
    public int lon;
    public ArrayList<Short> speedLimit;
    public ArrayList<GroupTimeRange> timeRange;
    @FacilityType.FacilityType1
    public int type;
    public int validLane;

    public RoadFacility() {
        this.type = 0;
        this.lon = 0;
        this.lat = 0;
        this.speedLimit = new ArrayList<>();
        this.distToEnd = 0;
        this.validLane = 0;
        this.laneNum = (short) 0;
        this.timeRange = new ArrayList<>();
    }

    public RoadFacility(@FacilityType.FacilityType1 int i, int i2, int i3, ArrayList<Short> arrayList, int i4, int i5, short s, ArrayList<GroupTimeRange> arrayList2) {
        this.type = i;
        this.lon = i2;
        this.lat = i3;
        this.speedLimit = arrayList;
        this.distToEnd = i4;
        this.validLane = i5;
        this.laneNum = s;
        this.timeRange = arrayList2;
    }
}

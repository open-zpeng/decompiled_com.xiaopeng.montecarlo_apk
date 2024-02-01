package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LocVision implements Serializable {
    @LocDataType.LocDataType1
    public int dataType;
    public int interval;
    public boolean isLaneInfoValid;
    public boolean isLaneNumValid;
    public boolean isRoadEdgeInfoValid;
    public int leftLaneCnt;
    public LocLaneNum leftLaneNum;
    public ArrayList<LocLane> leftLanes;
    public LocRoadEdgeInfo leftRoadEdgeInfo;
    public BigInteger localTickTime;
    public int rightLaneCnt;
    public LocLaneNum rightLaneNum;
    public ArrayList<LocLane> rightLanes;
    public LocRoadEdgeInfo rightRoadEdgeInfo;
    public long ticktime;

    public LocVision() {
        this.dataType = LocDataType.LocDataVision;
        this.ticktime = 0L;
        this.interval = 0;
        this.isLaneInfoValid = false;
        this.leftLaneCnt = 0;
        this.leftLanes = new ArrayList<>();
        this.rightLaneCnt = 0;
        this.rightLanes = new ArrayList<>();
        this.isLaneNumValid = false;
        this.leftLaneNum = new LocLaneNum();
        this.rightLaneNum = new LocLaneNum();
        this.isRoadEdgeInfoValid = false;
        this.leftRoadEdgeInfo = new LocRoadEdgeInfo();
        this.rightRoadEdgeInfo = new LocRoadEdgeInfo();
        this.localTickTime = new BigInteger("0");
    }

    public LocVision(@LocDataType.LocDataType1 int i, long j, int i2, boolean z, int i3, ArrayList<LocLane> arrayList, int i4, ArrayList<LocLane> arrayList2, boolean z2, LocLaneNum locLaneNum, LocLaneNum locLaneNum2, boolean z3, LocRoadEdgeInfo locRoadEdgeInfo, LocRoadEdgeInfo locRoadEdgeInfo2, BigInteger bigInteger) {
        this.dataType = i;
        this.ticktime = j;
        this.interval = i2;
        this.isLaneInfoValid = z;
        this.leftLaneCnt = i3;
        this.leftLanes = arrayList;
        this.rightLaneCnt = i4;
        this.rightLanes = arrayList2;
        this.isLaneNumValid = z2;
        this.leftLaneNum = locLaneNum;
        this.rightLaneNum = locLaneNum2;
        this.isRoadEdgeInfoValid = z3;
        this.leftRoadEdgeInfo = locRoadEdgeInfo;
        this.rightRoadEdgeInfo = locRoadEdgeInfo2;
        this.localTickTime = bigInteger;
    }
}

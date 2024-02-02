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
    public short laneNum;
    public short laneNumIncludeSpecial;
    public int leftLaneCnt;
    public short leftLaneNum;
    public short leftLaneNumIncludeSpecial;
    public double leftLaneNumQuality;
    public double leftLaneNumQualityIncludeSpecial;
    public ArrayList<LocLane> leftLanes;
    public BigInteger localTickTime;
    public short rawLeftLaneNum;
    public short rawLeftLaneNumIncludeSpecial;
    public short rawRightLaneNum;
    public short rawRightLaneNumIncludeSpecial;
    public int rightLaneCnt;
    public short rightLaneNum;
    public short rightLaneNumIncludeSpecial;
    public double rightLaneNumQuality;
    public double rightLaneNumQualityIncludeSpecial;
    public ArrayList<LocLane> rightLanes;
    public long ticktimeCV;
    public long ticktimeMCU;

    public LocVision() {
        this.dataType = LocDataType.LocDataVision;
        this.leftLaneCnt = 0;
        this.rightLaneCnt = 0;
        this.leftLanes = new ArrayList<>();
        this.rightLanes = new ArrayList<>();
        this.interval = 0;
        this.ticktimeMCU = 0L;
        this.ticktimeCV = 0L;
        this.laneNumIncludeSpecial = (short) 0;
        this.leftLaneNumIncludeSpecial = (short) 0;
        this.rightLaneNumIncludeSpecial = (short) 0;
        this.rawLeftLaneNumIncludeSpecial = (short) 0;
        this.rawRightLaneNumIncludeSpecial = (short) 0;
        this.leftLaneNumQualityIncludeSpecial = 0.0d;
        this.rightLaneNumQualityIncludeSpecial = 0.0d;
        this.laneNum = (short) 0;
        this.leftLaneNum = (short) 0;
        this.rightLaneNum = (short) 0;
        this.rawLeftLaneNum = (short) 0;
        this.rawRightLaneNum = (short) 0;
        this.leftLaneNumQuality = 0.0d;
        this.rightLaneNumQuality = 0.0d;
        this.localTickTime = new BigInteger("0");
    }

    public LocVision(@LocDataType.LocDataType1 int i, int i2, int i3, ArrayList<LocLane> arrayList, ArrayList<LocLane> arrayList2, int i4, long j, long j2, short s, short s2, short s3, short s4, short s5, double d, double d2, short s6, short s7, short s8, short s9, short s10, double d3, double d4, BigInteger bigInteger) {
        this.dataType = i;
        this.leftLaneCnt = i2;
        this.rightLaneCnt = i3;
        this.leftLanes = arrayList;
        this.rightLanes = arrayList2;
        this.interval = i4;
        this.ticktimeMCU = j;
        this.ticktimeCV = j2;
        this.laneNumIncludeSpecial = s;
        this.leftLaneNumIncludeSpecial = s2;
        this.rightLaneNumIncludeSpecial = s3;
        this.rawLeftLaneNumIncludeSpecial = s4;
        this.rawRightLaneNumIncludeSpecial = s5;
        this.leftLaneNumQualityIncludeSpecial = d;
        this.rightLaneNumQualityIncludeSpecial = d2;
        this.laneNum = s6;
        this.leftLaneNum = s7;
        this.rightLaneNum = s8;
        this.rawLeftLaneNum = s9;
        this.rawRightLaneNum = s10;
        this.leftLaneNumQuality = d3;
        this.rightLaneNumQuality = d4;
        this.localTickTime = bigInteger;
    }
}

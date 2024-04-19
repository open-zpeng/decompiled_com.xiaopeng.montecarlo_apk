package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.pos.model.LaneProbLevel;
/* loaded from: classes2.dex */
public class LocLaneMatchInfo {
    public float course;
    public int laneCnt;
    public float laneDis2End;
    public float laneDis2EndPercent;
    public float laneGroupDis2End;
    public float laneGroupDis2EndPercent;
    public long laneGroupId;
    public LaneResIndicator laneIndicator;
    public int laneNum;
    public float laneProb;
    @LaneProbLevel.LaneProbLevel1
    public int laneProbLevel;
    public long linkId;
    public Coord3DDouble pos;

    public LocLaneMatchInfo() {
        this.laneProbLevel = 0;
        this.laneNum = 0;
        this.laneCnt = 0;
        this.laneGroupId = 0L;
        this.linkId = 0L;
        this.laneProb = 0.0f;
        this.pos = new Coord3DDouble();
        this.course = 0.0f;
        this.laneGroupDis2End = 0.0f;
        this.laneDis2End = 0.0f;
        this.laneGroupDis2EndPercent = 0.0f;
        this.laneDis2EndPercent = 0.0f;
        this.laneIndicator = new LaneResIndicator();
    }

    public LocLaneMatchInfo(@LaneProbLevel.LaneProbLevel1 int i, int i2, int i3, long j, long j2, float f, Coord3DDouble coord3DDouble, float f2, float f3, float f4, float f5, float f6, LaneResIndicator laneResIndicator) {
        this.laneProbLevel = i;
        this.laneNum = i2;
        this.laneCnt = i3;
        this.laneGroupId = j;
        this.linkId = j2;
        this.laneProb = f;
        this.pos = coord3DDouble;
        this.course = f2;
        this.laneGroupDis2End = f3;
        this.laneDis2End = f4;
        this.laneGroupDis2EndPercent = f5;
        this.laneDis2EndPercent = f6;
        this.laneIndicator = laneResIndicator;
    }
}

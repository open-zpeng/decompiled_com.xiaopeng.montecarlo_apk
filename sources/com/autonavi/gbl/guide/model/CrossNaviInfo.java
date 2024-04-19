package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.AssistantAction;
import com.autonavi.gbl.common.path.model.MainAction;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CrossNaviInfo implements Serializable {
    @AssistantAction.AssistantAction1
    public int assistAction;
    public int crossManeuverID;
    public int curToSegmentDist;
    public int curToSegmentTime;
    public short destDirection;
    @MainAction.MainAction1
    public int mainAction;
    public int maneuverID;
    public String nextRoadName;
    public short outCnt;
    public long pathID;
    public short rev;
    public short reversed;
    public int segIdx;
    public short tunnelFlag;
    public short viaNum;

    public CrossNaviInfo() {
        this.pathID = 0L;
        this.segIdx = 0;
        this.mainAction = 0;
        this.assistAction = 0;
        this.maneuverID = 0;
        this.crossManeuverID = 0;
        this.nextRoadName = "";
        this.curToSegmentDist = 0;
        this.curToSegmentTime = 0;
        this.outCnt = (short) 0;
        this.viaNum = (short) 0;
        this.destDirection = (short) 0;
        this.tunnelFlag = (short) 0;
        this.reversed = (short) 0;
        this.rev = (short) 0;
    }

    public CrossNaviInfo(long j, int i, @MainAction.MainAction1 int i2, @AssistantAction.AssistantAction1 int i3, int i4, int i5, String str, int i6, int i7, short s, short s2, short s3, short s4, short s5, short s6) {
        this.pathID = j;
        this.segIdx = i;
        this.mainAction = i2;
        this.assistAction = i3;
        this.maneuverID = i4;
        this.crossManeuverID = i5;
        this.nextRoadName = str;
        this.curToSegmentDist = i6;
        this.curToSegmentTime = i7;
        this.outCnt = s;
        this.viaNum = s2;
        this.destDirection = s3;
        this.tunnelFlag = s4;
        this.reversed = s5;
        this.rev = s6;
    }
}

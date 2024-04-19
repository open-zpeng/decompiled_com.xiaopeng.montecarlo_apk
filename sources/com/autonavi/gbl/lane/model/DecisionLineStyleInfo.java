package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneUniversalAnimationType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DecisionLineStyleInfo implements Serializable {
    public LaneLineStyleInfo arrowStyle;
    @LaneUniversalAnimationType.LaneUniversalAnimationType1
    public int decisionAnimationType;
    public LaneLineStyleInfo decisionStyle;
    @LaneUniversalAnimationType.LaneUniversalAnimationType1
    public int highLightAnimationType;
    public int highLightResID;
    @LaneUniversalAnimationType.LaneUniversalAnimationType1
    public int lccAnimationType;
    public LaneLineStyleInfo lccStyle;
    public LaneLineStyleInfo warningStyle;

    public DecisionLineStyleInfo() {
        this.decisionStyle = new LaneLineStyleInfo();
        this.decisionAnimationType = 0;
        this.arrowStyle = new LaneLineStyleInfo();
        this.highLightResID = -1;
        this.highLightAnimationType = 0;
        this.warningStyle = new LaneLineStyleInfo();
        this.lccStyle = new LaneLineStyleInfo();
        this.lccAnimationType = 0;
    }

    public DecisionLineStyleInfo(LaneLineStyleInfo laneLineStyleInfo, @LaneUniversalAnimationType.LaneUniversalAnimationType1 int i, LaneLineStyleInfo laneLineStyleInfo2, int i2, @LaneUniversalAnimationType.LaneUniversalAnimationType1 int i3, LaneLineStyleInfo laneLineStyleInfo3, LaneLineStyleInfo laneLineStyleInfo4, @LaneUniversalAnimationType.LaneUniversalAnimationType1 int i4) {
        this.decisionStyle = laneLineStyleInfo;
        this.decisionAnimationType = i;
        this.arrowStyle = laneLineStyleInfo2;
        this.highLightResID = i2;
        this.highLightAnimationType = i3;
        this.warningStyle = laneLineStyleInfo3;
        this.lccStyle = laneLineStyleInfo4;
        this.lccAnimationType = i4;
    }
}

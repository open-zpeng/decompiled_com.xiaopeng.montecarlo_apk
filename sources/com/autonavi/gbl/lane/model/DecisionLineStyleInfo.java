package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DecisionLineStyleInfo implements Serializable {
    public LaneLineStyleInfo arrowStyle;
    public LaneLineStyleInfo decisionStyle;
    public int highLightResID;
    public LaneLineStyleInfo lccStyle;
    public LaneLineStyleInfo warningStyle;

    public DecisionLineStyleInfo() {
        this.decisionStyle = new LaneLineStyleInfo();
        this.arrowStyle = new LaneLineStyleInfo();
        this.highLightResID = -1;
        this.warningStyle = new LaneLineStyleInfo();
        this.lccStyle = new LaneLineStyleInfo();
    }

    public DecisionLineStyleInfo(LaneLineStyleInfo laneLineStyleInfo, LaneLineStyleInfo laneLineStyleInfo2, int i, LaneLineStyleInfo laneLineStyleInfo3, LaneLineStyleInfo laneLineStyleInfo4) {
        this.decisionStyle = laneLineStyleInfo;
        this.arrowStyle = laneLineStyleInfo2;
        this.highLightResID = i;
        this.warningStyle = laneLineStyleInfo3;
        this.lccStyle = laneLineStyleInfo4;
    }
}

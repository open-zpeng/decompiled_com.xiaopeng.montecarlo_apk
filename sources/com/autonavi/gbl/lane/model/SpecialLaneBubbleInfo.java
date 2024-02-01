package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.BubbleNotifyType;
import com.autonavi.gbl.lane.model.RoadLaneType;
import java.io.Serializable;
@Deprecated
/* loaded from: classes.dex */
public class SpecialLaneBubbleInfo implements Serializable {
    @BubbleDirectionType.BubbleDirectionType1
    public int bubbleSide;
    @RoadLaneType.RoadLaneType1
    public int laneType;
    @BubbleNotifyType.BubbleNotifyType1
    public int notifyType;
    public Coord3DDouble pos3D;

    public SpecialLaneBubbleInfo() {
        this.laneType = 0;
        this.notifyType = 0;
        this.bubbleSide = 0;
        this.pos3D = new Coord3DDouble();
    }

    public SpecialLaneBubbleInfo(@RoadLaneType.RoadLaneType1 int i, @BubbleNotifyType.BubbleNotifyType1 int i2, @BubbleDirectionType.BubbleDirectionType1 int i3, Coord3DDouble coord3DDouble) {
        this.laneType = i;
        this.notifyType = i2;
        this.bubbleSide = i3;
        this.pos3D = coord3DDouble;
    }
}

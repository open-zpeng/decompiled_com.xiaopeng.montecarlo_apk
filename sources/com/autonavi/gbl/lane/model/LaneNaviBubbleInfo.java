package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.LaneNaviBubbleType;
import java.io.Serializable;
@Deprecated
/* loaded from: classes.dex */
public class LaneNaviBubbleInfo implements Serializable {
    @BubbleDirectionType.BubbleDirectionType1
    public int bubbleSide;
    @LaneNaviBubbleType.LaneNaviBubbleType1
    public int bubbleType;
    public Coord3DDouble showPos3D;

    public LaneNaviBubbleInfo() {
        this.bubbleType = 0;
        this.bubbleSide = 0;
        this.showPos3D = new Coord3DDouble();
    }

    public LaneNaviBubbleInfo(@LaneNaviBubbleType.LaneNaviBubbleType1 int i, @BubbleDirectionType.BubbleDirectionType1 int i2, Coord3DDouble coord3DDouble) {
        this.bubbleType = i;
        this.bubbleSide = i2;
        this.showPos3D = coord3DDouble;
    }
}

package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.BubbleNotifyType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TurnBubbleInfo implements Serializable {
    @BubbleDirectionType.BubbleDirectionType1
    public int direction;
    public short mainAction;
    @BubbleNotifyType.BubbleNotifyType1
    public int notifyType;
    public long pathID;
    public long remainDist;
    public int segmentID;
    public Coord3DDouble showPos3D;

    public TurnBubbleInfo() {
        this.pathID = 0L;
        this.segmentID = 0;
        this.notifyType = 0;
        this.mainAction = (short) 0;
        this.showPos3D = new Coord3DDouble();
        this.direction = 0;
        this.remainDist = 0L;
    }

    public TurnBubbleInfo(long j, int i, @BubbleNotifyType.BubbleNotifyType1 int i2, short s, Coord3DDouble coord3DDouble, @BubbleDirectionType.BubbleDirectionType1 int i3, long j2) {
        this.pathID = j;
        this.segmentID = i;
        this.notifyType = i2;
        this.mainAction = s;
        this.showPos3D = coord3DDouble;
        this.direction = i3;
        this.remainDist = j2;
    }
}

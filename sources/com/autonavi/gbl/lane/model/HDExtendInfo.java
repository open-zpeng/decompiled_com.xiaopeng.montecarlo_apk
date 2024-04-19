package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.PositionAdjustStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class HDExtendInfo implements Serializable {
    @PositionAdjustStatus.PositionAdjustStatus1
    public int adjustStatus;
    public Coord3DDouble coord3D;
    @BubbleDirectionType.BubbleDirectionType1
    public int direction;

    public HDExtendInfo() {
        this.coord3D = new Coord3DDouble();
        this.direction = 0;
        this.adjustStatus = 0;
    }

    public HDExtendInfo(Coord3DDouble coord3DDouble, @BubbleDirectionType.BubbleDirectionType1 int i, @PositionAdjustStatus.PositionAdjustStatus1 int i2) {
        this.coord3D = coord3DDouble;
        this.direction = i;
        this.adjustStatus = i2;
    }
}

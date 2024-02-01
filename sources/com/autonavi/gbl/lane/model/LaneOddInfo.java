package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.lane.model.OddPointType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneOddInfo implements Serializable {
    public HDExtendInfo hdExtendInfo;
    public long pathID;
    public Coord3DDouble showPos3D;
    @OddPointType.OddPointType1
    public int type;

    public LaneOddInfo() {
        this.pathID = 0L;
        this.type = -1;
        this.showPos3D = new Coord3DDouble();
        this.hdExtendInfo = new HDExtendInfo();
    }

    public LaneOddInfo(long j, @OddPointType.OddPointType1 int i, Coord3DDouble coord3DDouble, HDExtendInfo hDExtendInfo) {
        this.pathID = j;
        this.type = i;
        this.showPos3D = coord3DDouble;
        this.hdExtendInfo = hDExtendInfo;
    }
}

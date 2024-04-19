package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.lane.model.TravelPointType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TravelPoint implements Serializable {
    public HDExtendInfo hdExtendInfo;
    public int index;
    public long pathID;
    public Coord3DDouble showPos3D;
    @TravelPointType.TravelPointType1
    public int type;

    public TravelPoint() {
        this.pathID = 0L;
        this.index = 0;
        this.type = 2;
        this.showPos3D = new Coord3DDouble();
        this.hdExtendInfo = new HDExtendInfo();
    }

    public TravelPoint(long j, int i, @TravelPointType.TravelPointType1 int i2, Coord3DDouble coord3DDouble, HDExtendInfo hDExtendInfo) {
        this.pathID = j;
        this.index = i;
        this.type = i2;
        this.showPos3D = coord3DDouble;
        this.hdExtendInfo = hDExtendInfo;
    }
}

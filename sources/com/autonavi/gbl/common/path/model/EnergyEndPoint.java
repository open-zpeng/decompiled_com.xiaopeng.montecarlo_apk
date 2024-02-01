package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class EnergyEndPoint implements Serializable {
    public short linkIndex;
    public short segmentIdx;
    public Coord2DDouble show;

    public EnergyEndPoint() {
        this.show = new Coord2DDouble();
        this.segmentIdx = (short) 0;
        this.linkIndex = (short) 0;
    }

    public EnergyEndPoint(Coord2DDouble coord2DDouble, short s, short s2) {
        this.show = coord2DDouble;
        this.segmentIdx = s;
        this.linkIndex = s2;
    }
}

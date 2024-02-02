package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ViaPointInfo implements Serializable {
    public byte direction;
    public String poiName;
    public Coord2DDouble projective;
    public short segmentIdx;
    public Coord2DDouble show;

    public ViaPointInfo() {
        this.segmentIdx = (short) 0;
        this.direction = (byte) 0;
        this.show = new Coord2DDouble();
        this.projective = new Coord2DDouble();
        this.poiName = "";
    }

    public ViaPointInfo(short s, byte b, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, String str) {
        this.segmentIdx = s;
        this.direction = b;
        this.show = coord2DDouble;
        this.projective = coord2DDouble2;
        this.poiName = str;
    }
}

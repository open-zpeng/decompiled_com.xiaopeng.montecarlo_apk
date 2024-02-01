package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ElecPoiInfo implements Serializable {
    public byte direction;
    public POIInfo poiInfo;
    public Coord2DDouble projective;
    public int remainingCapacity;
    public double remainingPercent;
    public short segmentIdx;
    public Coord2DDouble show;

    public ElecPoiInfo() {
        this.poiInfo = new POIInfo();
        this.segmentIdx = (short) 0;
        this.direction = (byte) 0;
        this.show = new Coord2DDouble();
        this.projective = new Coord2DDouble();
        this.remainingCapacity = 0;
        this.remainingPercent = 0.0d;
    }

    public ElecPoiInfo(POIInfo pOIInfo, short s, byte b, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, int i, double d) {
        this.poiInfo = pOIInfo;
        this.segmentIdx = s;
        this.direction = b;
        this.show = coord2DDouble;
        this.projective = coord2DDouble2;
        this.remainingCapacity = i;
        this.remainingPercent = d;
    }
}

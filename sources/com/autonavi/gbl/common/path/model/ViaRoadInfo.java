package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ViaRoadInfo implements Serializable {
    public int aggregateLenth;
    public short maxLaneNum;
    public short maxLimitSpeed;
    public short minLaneNum;
    public short minLimitSpeed;
    public Coord2DDouble point;
    public short reserved;
    public short roadClass;
    public String roadName;

    public ViaRoadInfo() {
        this.roadName = "";
        this.minLaneNum = (short) 0;
        this.maxLaneNum = (short) 0;
        this.minLimitSpeed = (short) 0;
        this.maxLimitSpeed = (short) 0;
        this.aggregateLenth = 0;
        this.roadClass = (short) 0;
        this.reserved = (short) 0;
        this.point = new Coord2DDouble();
    }

    public ViaRoadInfo(String str, short s, short s2, short s3, short s4, int i, short s5, short s6, Coord2DDouble coord2DDouble) {
        this.roadName = str;
        this.minLaneNum = s;
        this.maxLaneNum = s2;
        this.minLimitSpeed = s3;
        this.maxLimitSpeed = s4;
        this.aggregateLenth = i;
        this.roadClass = s5;
        this.reserved = s6;
        this.point = coord2DDouble;
    }
}

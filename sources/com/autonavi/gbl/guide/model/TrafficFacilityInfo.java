package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TrafficFacilityInfo implements Serializable {
    public int boardcastType;
    public int limitSpeed;
    public Coord2DDouble pos;
    public int remainDist;

    public TrafficFacilityInfo() {
        this.pos = new Coord2DDouble();
        this.boardcastType = 0;
        this.remainDist = 0;
        this.limitSpeed = 0;
    }

    public TrafficFacilityInfo(Coord2DDouble coord2DDouble, int i, int i2, int i3) {
        this.pos = coord2DDouble;
        this.boardcastType = i;
        this.remainDist = i2;
        this.limitSpeed = i3;
    }
}

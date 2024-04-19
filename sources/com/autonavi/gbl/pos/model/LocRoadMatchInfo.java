package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.common.path.model.LinkType;
/* loaded from: classes2.dex */
public class LocRoadMatchInfo {
    public float course;
    @Formway.Formway1
    public int formway;
    public PosGeoLineRoadId fromRoadId;
    @LinkType.LinkType1
    public int linkType;
    public float passedLen;
    public Coord3DDouble pos;
    public float probability;
    public PosGeoLineRoadId roadId;
    public float roadLen;

    public LocRoadMatchInfo() {
        this.roadId = new PosGeoLineRoadId();
        this.fromRoadId = new PosGeoLineRoadId();
        this.pos = new Coord3DDouble();
        this.course = 0.0f;
        this.roadLen = 0.0f;
        this.passedLen = 0.0f;
        this.formway = 0;
        this.linkType = 0;
        this.probability = 0.0f;
    }

    public LocRoadMatchInfo(PosGeoLineRoadId posGeoLineRoadId, PosGeoLineRoadId posGeoLineRoadId2, Coord3DDouble coord3DDouble, float f, float f2, float f3, @Formway.Formway1 int i, @LinkType.LinkType1 int i2, float f4) {
        this.roadId = posGeoLineRoadId;
        this.fromRoadId = posGeoLineRoadId2;
        this.pos = coord3DDouble;
        this.course = f;
        this.roadLen = f2;
        this.passedLen = f3;
        this.formway = i;
        this.linkType = i2;
        this.probability = f4;
    }
}

package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.common.path.model.LinkType;
import com.autonavi.gbl.common.path.model.RoadClass;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocLaneInfo implements Serializable {
    public float boundaryHeadingLeft;
    public float boundaryHeadingRight;
    public int connectivityEleCnt;
    public int connectivityEleIdx;
    public byte[] connectivityEleIndices;
    public float[] connectivityEleProbs;
    public float course;
    @Formway.Formway1
    public int formway;
    public float laneCourse;
    public int laneGroupId;
    public float lateralOffsetLeft;
    public float lateralOffsetRight;
    @LinkType.LinkType1
    public int linkType;
    public float passedLen;
    public Coord3DDouble pos;
    @RoadClass.RoadClass1
    public int roadClass;
    public PosGeoLineRoadId roadId;
    public float roadLen;
    public float stdLateralPos;
    public float stdLongitudinalPos;

    public LocLaneInfo() {
        this.roadId = new PosGeoLineRoadId();
        this.roadLen = -1.0f;
        this.passedLen = -1.0f;
        this.formway = -1;
        this.linkType = -1;
        this.roadClass = -1;
        this.laneGroupId = -1;
        this.connectivityEleCnt = 0;
        this.connectivityEleIdx = -1;
        this.laneCourse = -1.0f;
        this.pos = new Coord3DDouble();
        this.course = -1.0f;
        this.lateralOffsetLeft = -1.0f;
        this.lateralOffsetRight = -1.0f;
        this.boundaryHeadingLeft = -1.0f;
        this.boundaryHeadingRight = -1.0f;
        this.stdLateralPos = 1000000.0f;
        this.stdLongitudinalPos = 1000000.0f;
        this.connectivityEleIndices = new byte[3];
        this.connectivityEleProbs = new float[3];
    }

    public LocLaneInfo(PosGeoLineRoadId posGeoLineRoadId, float f, float f2, @Formway.Formway1 int i, @LinkType.LinkType1 int i2, @RoadClass.RoadClass1 int i3, int i4, int i5, int i6, float f3, byte[] bArr, float[] fArr, Coord3DDouble coord3DDouble, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.roadId = posGeoLineRoadId;
        this.roadLen = f;
        this.passedLen = f2;
        this.formway = i;
        this.linkType = i2;
        this.roadClass = i3;
        this.laneGroupId = i4;
        this.connectivityEleCnt = i5;
        this.connectivityEleIdx = i6;
        this.laneCourse = f3;
        this.connectivityEleIndices = bArr;
        this.connectivityEleProbs = fArr;
        this.pos = coord3DDouble;
        this.course = f4;
        this.lateralOffsetLeft = f5;
        this.lateralOffsetRight = f6;
        this.boundaryHeadingLeft = f7;
        this.boundaryHeadingRight = f8;
        this.stdLateralPos = f9;
        this.stdLongitudinalPos = f10;
    }
}

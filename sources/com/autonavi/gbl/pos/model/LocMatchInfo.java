package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.common.path.model.LinkType;
import com.autonavi.gbl.common.path.model.Ownership;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.pos.model.LocMatchRouteType;
import com.autonavi.gbl.pos.model.LocOnRouteState;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocMatchInfo implements Serializable {
    public float course;
    public float course3D;
    public float elevation;
    @Formway.Formway1
    public int formway;
    public long fromLinkId;
    public int is3DValid;
    @LocOnRouteState.LocOnRouteState1
    public int isOnGuideRoad;
    public LocLaneMatchInfo laneMatchInfo;
    public int linkCur;
    public long linkId;
    @LinkType.LinkType1
    public int linkType;
    @LocMatchRouteType.LocMatchRouteType1
    public int matchRouteType;
    @Ownership.Ownership1
    public int ownership;
    public float passedLen;
    public long pathID;
    public Coord3DDouble posProj;
    public int postCur;
    public int postCur3D;
    public float probability;
    @RoadClass.RoadClass1
    public int roadClass;
    public float roadCourse;
    public float roadLen;
    public int segmCur;
    public Coord3DDouble st3DPos;
    public Coord3DDouble stPos;
    public int weight;

    public LocMatchInfo() {
        this.stPos = new Coord3DDouble();
        this.course = 0.0f;
        this.roadCourse = 0.0f;
        this.st3DPos = new Coord3DDouble();
        this.elevation = 0.0f;
        this.course3D = 0.0f;
        this.posProj = new Coord3DDouble();
        this.is3DValid = 0;
        this.linkId = 0L;
        this.fromLinkId = 0L;
        this.roadLen = 0.0f;
        this.passedLen = 0.0f;
        this.formway = -1;
        this.linkType = -1;
        this.roadClass = -1;
        this.ownership = 0;
        this.segmCur = 0;
        this.linkCur = 0;
        this.postCur = 0;
        this.postCur3D = 0;
        this.isOnGuideRoad = 0;
        this.pathID = 0L;
        this.weight = 0;
        this.matchRouteType = 0;
        this.probability = 0.0f;
        this.laneMatchInfo = new LocLaneMatchInfo();
    }

    public LocMatchInfo(Coord3DDouble coord3DDouble, float f, float f2, Coord3DDouble coord3DDouble2, float f3, float f4, Coord3DDouble coord3DDouble3, int i, long j, long j2, float f5, float f6, @Formway.Formway1 int i2, @LinkType.LinkType1 int i3, @RoadClass.RoadClass1 int i4, @Ownership.Ownership1 int i5, int i6, int i7, int i8, int i9, @LocOnRouteState.LocOnRouteState1 int i10, long j3, int i11, @LocMatchRouteType.LocMatchRouteType1 int i12, float f7, LocLaneMatchInfo locLaneMatchInfo) {
        this.stPos = coord3DDouble;
        this.course = f;
        this.roadCourse = f2;
        this.st3DPos = coord3DDouble2;
        this.elevation = f3;
        this.course3D = f4;
        this.posProj = coord3DDouble3;
        this.is3DValid = i;
        this.linkId = j;
        this.fromLinkId = j2;
        this.roadLen = f5;
        this.passedLen = f6;
        this.formway = i2;
        this.linkType = i3;
        this.roadClass = i4;
        this.ownership = i5;
        this.segmCur = i6;
        this.linkCur = i7;
        this.postCur = i8;
        this.postCur3D = i9;
        this.isOnGuideRoad = i10;
        this.pathID = j3;
        this.weight = i11;
        this.matchRouteType = i12;
        this.probability = f7;
        this.laneMatchInfo = locLaneMatchInfo;
    }
}

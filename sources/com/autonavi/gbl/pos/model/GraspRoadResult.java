package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.RoadClass;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GraspRoadResult implements Serializable {
    public BigInteger eventId;
    public boolean isValid;
    public float length;
    public int naviDir;
    public double offset;
    public ArrayList<Coord3DDouble> pntArray;
    public float projCourse;
    public Coord3DDouble projPos;
    @RoadClass.RoadClass1
    public int roadClass;
    public PosGeoLineRoadId roadId;

    public GraspRoadResult() {
        this.isValid = false;
        this.eventId = new BigInteger("0");
        this.roadId = new PosGeoLineRoadId();
        this.projPos = new Coord3DDouble();
        this.projCourse = -1.0f;
        this.offset = -1.0d;
        this.naviDir = 0;
        this.length = -1.0f;
        this.roadClass = -1;
        this.pntArray = new ArrayList<>();
    }

    public GraspRoadResult(boolean z, BigInteger bigInteger, PosGeoLineRoadId posGeoLineRoadId, Coord3DDouble coord3DDouble, float f, double d, int i, float f2, @RoadClass.RoadClass1 int i2, ArrayList<Coord3DDouble> arrayList) {
        this.isValid = z;
        this.eventId = bigInteger;
        this.roadId = posGeoLineRoadId;
        this.projPos = coord3DDouble;
        this.projCourse = f;
        this.offset = d;
        this.naviDir = i;
        this.length = f2;
        this.roadClass = i2;
        this.pntArray = arrayList;
    }
}

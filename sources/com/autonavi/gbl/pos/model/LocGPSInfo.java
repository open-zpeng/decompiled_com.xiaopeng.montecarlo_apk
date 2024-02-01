package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.common.path.model.LinkType;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.pos.model.LocOnRouteState;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocGPSInfo implements Serializable {
    public float accuracy;
    public float azi;
    public int checkStatus;
    @Formway.Formway1
    public int formway;
    public Coord3DInt32 gpsPos;
    public boolean hasRoute;
    public boolean hasRouteMatch;
    @LinkType.LinkType1
    public int linkType;
    @LocOnRouteState.LocOnRouteState1
    public int locOnRouteState;
    public Coord3DInt32 matchPos;
    public int matchRouteState;
    @RoadClass.RoadClass1
    public int roadClass;
    public float speed;
    public BigInteger timestamp;
    public BigInteger timestampSystem;

    public LocGPSInfo() {
        this.timestamp = new BigInteger("0");
        this.timestampSystem = new BigInteger("0");
        this.gpsPos = new Coord3DInt32();
        this.speed = -999.0f;
        this.azi = -999.0f;
        this.accuracy = -999.0f;
        this.checkStatus = -1;
        this.hasRoute = false;
        this.hasRouteMatch = false;
        this.matchRouteState = -1;
        this.matchPos = new Coord3DInt32();
        this.formway = -1;
        this.linkType = -1;
        this.roadClass = -1;
        this.locOnRouteState = 0;
        Coord3DInt32 coord3DInt32 = this.gpsPos;
        coord3DInt32.lat = -999000000;
        coord3DInt32.lon = -999000000;
        coord3DInt32.z = -999;
        Coord3DInt32 coord3DInt322 = this.matchPos;
        coord3DInt322.lat = -999000000;
        coord3DInt322.lon = -999000000;
        coord3DInt322.z = -999;
    }

    public LocGPSInfo(BigInteger bigInteger, BigInteger bigInteger2, Coord3DInt32 coord3DInt32, float f, float f2, float f3, int i, boolean z, boolean z2, int i2, Coord3DInt32 coord3DInt322, @Formway.Formway1 int i3, @LinkType.LinkType1 int i4, @RoadClass.RoadClass1 int i5, @LocOnRouteState.LocOnRouteState1 int i6) {
        this.timestamp = bigInteger;
        this.timestampSystem = bigInteger2;
        this.gpsPos = coord3DInt32;
        this.speed = f;
        this.azi = f2;
        this.accuracy = f3;
        this.checkStatus = i;
        this.hasRoute = z;
        this.hasRouteMatch = z2;
        this.matchRouteState = i2;
        this.matchPos = coord3DInt322;
        this.formway = i3;
        this.linkType = i4;
        this.roadClass = i5;
        this.locOnRouteState = i6;
    }
}

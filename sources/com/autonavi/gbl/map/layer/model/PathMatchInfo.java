package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PathMatchInfo implements Serializable {
    public boolean bVaild3D;
    public float carDir;
    public int index2d;
    public int index3d;
    public double lat3D;
    public double latitude;
    public double lon3D;
    public double longitude;
    public int matchStatus;
    public int nIsOnGuideRoad;
    public int nLinkCur;
    public long nNaviRouteId;
    public int nPostCur;
    public int nSegmCur;
    public double scale2d;
    public double scale3d;
    public double z3D;

    public PathMatchInfo() {
        this.nSegmCur = 0;
        this.nLinkCur = 0;
        this.nPostCur = 0;
        this.nIsOnGuideRoad = 0;
        this.nNaviRouteId = 0L;
        this.matchStatus = 0;
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        this.carDir = 0.0f;
        this.lon3D = 0.0d;
        this.lat3D = 0.0d;
        this.z3D = 0.0d;
        this.bVaild3D = false;
        this.index2d = -1;
        this.index3d = -1;
        this.scale2d = 0.0d;
        this.scale3d = 0.0d;
    }

    public PathMatchInfo(int i, int i2, int i3, int i4, long j, int i5, double d, double d2, float f, double d3, double d4, double d5, boolean z, int i6, int i7, double d6, double d7) {
        this.nSegmCur = i;
        this.nLinkCur = i2;
        this.nPostCur = i3;
        this.nIsOnGuideRoad = i4;
        this.nNaviRouteId = j;
        this.matchStatus = i5;
        this.longitude = d;
        this.latitude = d2;
        this.carDir = f;
        this.lon3D = d3;
        this.lat3D = d4;
        this.z3D = d5;
        this.bVaild3D = z;
        this.index2d = i6;
        this.index3d = i7;
        this.scale2d = d6;
        this.scale3d = d7;
    }
}

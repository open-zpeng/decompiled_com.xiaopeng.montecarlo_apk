package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RealCityNaviInfo implements Serializable {
    public int currentLinkNumber;
    public int currentSegNumber;
    public int end3DLinkNumber;
    public int maneuverID;
    public long routeRemainDistance;
    public long routeRemainTime;
    public int segmentLength;
    public int segmentRemainDistance;
    public int segmentRemainTime;
    public int start3DLinkNumber;
    public int type;

    public RealCityNaviInfo() {
        this.type = 0;
        this.maneuverID = 0;
        this.routeRemainDistance = 0L;
        this.routeRemainTime = 0L;
        this.segmentRemainDistance = 0;
        this.segmentLength = 0;
        this.segmentRemainTime = 0;
        this.currentSegNumber = 0;
        this.currentLinkNumber = 0;
        this.start3DLinkNumber = 0;
        this.end3DLinkNumber = 0;
    }

    public RealCityNaviInfo(int i, int i2, long j, long j2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.type = i;
        this.maneuverID = i2;
        this.routeRemainDistance = j;
        this.routeRemainTime = j2;
        this.segmentRemainDistance = i3;
        this.segmentLength = i4;
        this.segmentRemainTime = i5;
        this.currentSegNumber = i6;
        this.currentLinkNumber = i7;
        this.start3DLinkNumber = i8;
        this.end3DLinkNumber = i9;
    }
}

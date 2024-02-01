package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ManeuverConfig implements Serializable {
    public int arrowColor;
    public int backColor;
    public int deviceId;
    public int height;
    public long maneuverID;
    public long pathID;
    public int roadColor;
    public long segmentIdx;
    public int width;

    public ManeuverConfig() {
        this.deviceId = 0;
        this.width = 0;
        this.height = 0;
        this.backColor = 0;
        this.roadColor = 0;
        this.arrowColor = 0;
        this.pathID = 0L;
        this.segmentIdx = 0L;
        this.maneuverID = 0L;
    }

    public ManeuverConfig(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3) {
        this.deviceId = i;
        this.width = i2;
        this.height = i3;
        this.backColor = i4;
        this.roadColor = i5;
        this.arrowColor = i6;
        this.pathID = j;
        this.segmentIdx = j2;
        this.maneuverID = j3;
    }
}

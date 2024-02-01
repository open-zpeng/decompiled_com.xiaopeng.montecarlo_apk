package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CameraExtFeaturesFlag implements Serializable {
    public long catgory;
    public long platform;
    public long relBridge;
    public long relCross;
    public long relRoad;
    public long reserved;
    public long scene;

    public CameraExtFeaturesFlag() {
        this.catgory = 0L;
        this.relBridge = 0L;
        this.relRoad = 0L;
        this.relCross = 0L;
        this.platform = 0L;
        this.scene = 0L;
        this.reserved = 0L;
    }

    public CameraExtFeaturesFlag(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.catgory = j;
        this.relBridge = j2;
        this.relRoad = j3;
        this.relCross = j4;
        this.platform = j5;
        this.scene = j6;
        this.reserved = j7;
    }
}

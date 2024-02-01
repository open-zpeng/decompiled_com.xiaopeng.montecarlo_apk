package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DriveEvent implements Serializable {
    public float lat;
    public int level;
    public float lon;
    public long time;
    public int type;

    public DriveEvent() {
        this.type = 0;
        this.level = 0;
        this.lon = 0.0f;
        this.lat = 0.0f;
        this.time = 0L;
    }

    public DriveEvent(int i, int i2, float f, float f2, long j) {
        this.type = i;
        this.level = i2;
        this.lon = f;
        this.lat = f2;
        this.time = j;
    }
}

package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.path.model.CameraType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Camera implements Serializable {
    public int distToEnd;
    public long distance;
    public short flags;
    public double lat;
    public double lon;
    public long matchID;
    public short speed;
    @CameraType.CameraType1
    public int type;

    public Camera() {
        this.type = 0;
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.distToEnd = 0;
        this.matchID = 0L;
        this.distance = 0L;
        this.speed = (short) 0;
        this.flags = (short) 0;
    }

    public Camera(@CameraType.CameraType1 int i, double d, double d2, int i2, long j, long j2, short s, short s2) {
        this.type = i;
        this.lon = d;
        this.lat = d2;
        this.distToEnd = i2;
        this.matchID = j;
        this.distance = j2;
        this.speed = s;
        this.flags = s2;
    }
}

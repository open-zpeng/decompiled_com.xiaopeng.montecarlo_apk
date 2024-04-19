package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneCameraParam implements Serializable {
    public float pitch;
    public float roll;
    public double x;
    public double y;
    public float yaw;
    public double z;

    public LaneCameraParam() {
        this.pitch = 0.0f;
        this.yaw = 0.0f;
        this.roll = 0.0f;
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
    }

    public LaneCameraParam(float f, float f2, float f3, double d, double d2, double d3) {
        this.pitch = f;
        this.yaw = f2;
        this.roll = f3;
        this.x = d;
        this.y = d2;
        this.z = d3;
    }
}

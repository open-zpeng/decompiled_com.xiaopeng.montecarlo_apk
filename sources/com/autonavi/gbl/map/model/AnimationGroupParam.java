package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AnimationGroupParam implements Serializable {
    public double lat;
    public double lon;
    public float mapRollAngle;
    public float maplevel;
    public float pitchAngle;
    public double z;

    public AnimationGroupParam() {
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.z = 0.0d;
        this.maplevel = 0.0f;
        this.mapRollAngle = 0.0f;
        this.pitchAngle = 0.0f;
    }

    public AnimationGroupParam(double d, double d2, double d3, float f, float f2, float f3) {
        this.lon = d;
        this.lat = d2;
        this.z = d3;
        this.maplevel = f;
        this.mapRollAngle = f2;
        this.pitchAngle = f3;
    }
}

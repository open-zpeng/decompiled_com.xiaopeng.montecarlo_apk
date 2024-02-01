package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AnimationMoveParam implements Serializable {
    public double lat;
    public double lon;
    public double z;

    public AnimationMoveParam() {
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.z = 0.0d;
    }

    public AnimationMoveParam(double d, double d2, double d3) {
        this.lon = d;
        this.lat = d2;
        this.z = d3;
    }
}

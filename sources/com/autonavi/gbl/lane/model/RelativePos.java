package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RelativePos implements Serializable {
    public double x;
    public double y;
    public double z;

    public RelativePos() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
    }

    public RelativePos(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }
}

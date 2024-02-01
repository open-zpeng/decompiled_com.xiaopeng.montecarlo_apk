package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PosRotation implements Serializable {
    public double qw;
    public double qx;
    public double qy;
    public double qz;

    public PosRotation() {
        this.qx = 0.0d;
        this.qy = 0.0d;
        this.qz = 0.0d;
        this.qw = 0.0d;
    }

    public PosRotation(double d, double d2, double d3, double d4) {
        this.qx = d;
        this.qy = d2;
        this.qz = d3;
        this.qw = d4;
    }
}

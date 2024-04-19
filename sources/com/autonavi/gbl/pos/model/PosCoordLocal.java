package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PosCoordLocal implements Serializable {
    public double x;
    public double y;
    public double z;

    public PosCoordLocal() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
    }

    public PosCoordLocal(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }
}

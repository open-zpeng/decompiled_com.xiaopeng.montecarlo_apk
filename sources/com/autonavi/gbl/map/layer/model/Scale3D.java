package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Scale3D implements Serializable {
    public double x;
    public double y;
    public double z;

    public Scale3D() {
        this.x = 1.0d;
        this.y = 1.0d;
        this.z = 1.0d;
    }

    public Scale3D(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }
}

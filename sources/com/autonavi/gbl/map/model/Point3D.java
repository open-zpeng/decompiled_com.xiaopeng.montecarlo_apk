package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Point3D implements Serializable {
    public double x;
    public double y;
    public double z;

    public Point3D() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
    }

    public Point3D(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }
}

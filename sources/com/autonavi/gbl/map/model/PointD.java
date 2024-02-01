package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PointD implements Serializable {
    public double x;
    public double y;

    public PointD() {
        this.x = 0.0d;
        this.y = 0.0d;
    }

    public PointD(double d, double d2) {
        this.x = d;
        this.y = d2;
    }
}

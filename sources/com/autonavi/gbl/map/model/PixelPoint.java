package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PixelPoint implements Serializable {
    public double x;
    public double y;

    public PixelPoint() {
        this.x = 0.0d;
        this.y = 0.0d;
    }

    public PixelPoint(double d, double d2) {
        this.x = d;
        this.y = d2;
    }
}

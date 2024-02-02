package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RectDouble implements Serializable {
    public double bottom;
    public double left;
    public double right;
    public double top;

    public RectDouble() {
        this.left = 0.0d;
        this.right = 0.0d;
        this.top = 0.0d;
        this.bottom = 0.0d;
    }

    public RectDouble(double d, double d2, double d3, double d4) {
        this.left = d;
        this.right = d2;
        this.top = d3;
        this.bottom = d4;
    }
}

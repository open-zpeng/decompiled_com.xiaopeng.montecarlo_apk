package com.autonavi.gbl.map.model;
/* loaded from: classes.dex */
public class MapBound {
    public double height;
    public double left;
    public double top;
    public double width;

    public MapBound() {
        this.left = 0.0d;
        this.top = 0.0d;
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public MapBound(double d, double d2, double d3, double d4) {
        this.left = d;
        this.top = d2;
        this.width = d3;
        this.height = d4;
    }
}

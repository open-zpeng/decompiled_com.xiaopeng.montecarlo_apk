package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LineGeometry implements Serializable {
    public double c0;
    public double c1;
    public double c2;
    public double c3;
    public double qualityGeometry;
    public double viewRangeEnd;
    public double viewRangeStart;
    public double width;

    public LineGeometry() {
        this.c0 = 0.0d;
        this.c1 = 0.0d;
        this.c2 = 0.0d;
        this.c3 = 0.0d;
        this.width = 0.0d;
        this.qualityGeometry = 0.0d;
        this.viewRangeStart = 0.0d;
        this.viewRangeEnd = 0.0d;
    }

    public LineGeometry(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        this.c0 = d;
        this.c1 = d2;
        this.c2 = d3;
        this.c3 = d4;
        this.width = d5;
        this.qualityGeometry = d6;
        this.viewRangeStart = d7;
        this.viewRangeEnd = d8;
    }
}

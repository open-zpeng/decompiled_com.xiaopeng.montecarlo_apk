package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SectorAngles implements Serializable {
    public double endAngle;
    public double startAngle;
    public double stepAngle;

    public SectorAngles() {
        this.startAngle = 0.0d;
        this.endAngle = 180.0d;
        this.stepAngle = 1.0d;
    }

    public SectorAngles(double d, double d2, double d3) {
        this.startAngle = d;
        this.endAngle = d2;
        this.stepAngle = d3;
    }
}

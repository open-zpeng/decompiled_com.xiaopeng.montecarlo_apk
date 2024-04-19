package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LightBeamShape implements Serializable {
    public double baseRadius;
    public double height;
    public int sectorCount;
    public int stackCount;
    public double topRadius;

    public LightBeamShape() {
        this.baseRadius = 1.0d;
        this.topRadius = 0.6d;
        this.height = 2.0d;
        this.sectorCount = 36;
        this.stackCount = 1;
    }

    public LightBeamShape(double d, double d2, double d3, int i, int i2) {
        this.baseRadius = d;
        this.topRadius = d2;
        this.height = d3;
        this.sectorCount = i;
        this.stackCount = i2;
    }
}

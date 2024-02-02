package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ScaleInfo implements Serializable {
    public double bgScale;
    public double bubbleScale;
    public double poiScale;

    public ScaleInfo() {
        this.poiScale = 1.0d;
        this.bgScale = 1.0d;
        this.bubbleScale = 1.0d;
    }

    public ScaleInfo(double d, double d2, double d3) {
        this.poiScale = d;
        this.bgScale = d2;
        this.bubbleScale = d3;
    }
}

package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AnimationPivotZoomParam implements Serializable {
    public double px;
    public double py;
    public float toMaplevel;

    public AnimationPivotZoomParam() {
        this.px = 0.0d;
        this.py = 0.0d;
        this.toMaplevel = 0.0f;
    }

    public AnimationPivotZoomParam(double d, double d2, float f) {
        this.px = d;
        this.py = d2;
        this.toMaplevel = f;
    }
}

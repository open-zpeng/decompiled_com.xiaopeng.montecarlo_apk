package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AnimationZoomRotateParam implements Serializable {
    public boolean isRollcycle;
    public double px;
    public double py;
    public float toMapRollAngle;
    public float toMaplevel;

    public AnimationZoomRotateParam() {
        this.isRollcycle = false;
        this.px = 0.0d;
        this.py = 0.0d;
        this.toMaplevel = 0.0f;
        this.toMapRollAngle = 0.0f;
    }

    public AnimationZoomRotateParam(boolean z, double d, double d2, float f, float f2) {
        this.isRollcycle = z;
        this.px = d;
        this.py = d2;
        this.toMaplevel = f;
        this.toMapRollAngle = f2;
    }
}

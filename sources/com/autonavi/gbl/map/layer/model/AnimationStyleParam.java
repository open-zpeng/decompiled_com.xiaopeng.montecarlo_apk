package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AnimationStyleParam implements Serializable {
    public int duration;
    public double endAlpha;
    public double fromAlpha;

    public AnimationStyleParam() {
        this.duration = 800;
        this.fromAlpha = 1.0d;
        this.endAlpha = 0.0d;
    }

    public AnimationStyleParam(int i, double d, double d2) {
        this.duration = i;
        this.fromAlpha = d;
        this.endAlpha = d2;
    }
}

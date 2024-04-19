package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AnimationDeviationParam implements Serializable {
    public double leftEyeWitdhFactor;
    public double rightEyeWitdhFactor;

    public AnimationDeviationParam() {
        this.leftEyeWitdhFactor = 0.0d;
        this.rightEyeWitdhFactor = 0.0d;
    }

    public AnimationDeviationParam(double d, double d2) {
        this.leftEyeWitdhFactor = d;
        this.rightEyeWitdhFactor = d2;
    }
}

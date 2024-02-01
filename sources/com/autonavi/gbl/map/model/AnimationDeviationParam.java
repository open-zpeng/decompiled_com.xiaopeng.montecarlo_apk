package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AnimationDeviationParam implements Serializable {
    public double leftEyeWidthFactor;
    public double rightEyeWidthFactor;

    public AnimationDeviationParam() {
        this.leftEyeWidthFactor = 0.0d;
        this.rightEyeWidthFactor = 0.0d;
    }

    public AnimationDeviationParam(double d, double d2) {
        this.leftEyeWidthFactor = d;
        this.rightEyeWidthFactor = d2;
    }
}

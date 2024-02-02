package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ElecKeyPointConfig implements Serializable {
    public float keyPercent;
    public float remainingPower;
    public float toalPower;

    public ElecKeyPointConfig() {
        this.toalPower = 0.0f;
        this.remainingPower = 0.0f;
        this.keyPercent = 0.0f;
    }

    public ElecKeyPointConfig(float f, float f2, float f3) {
        this.toalPower = f;
        this.remainingPower = f2;
        this.keyPercent = f3;
    }
}

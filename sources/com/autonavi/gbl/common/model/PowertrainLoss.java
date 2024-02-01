package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PowertrainLoss implements Serializable {
    public float costValue;
    public float powerdemand;

    public PowertrainLoss() {
        this.powerdemand = 0.0f;
        this.costValue = 0.0f;
    }

    public PowertrainLoss(float f, float f2) {
        this.powerdemand = f;
        this.costValue = f2;
    }
}

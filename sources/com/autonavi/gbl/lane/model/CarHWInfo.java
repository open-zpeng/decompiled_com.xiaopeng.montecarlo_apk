package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CarHWInfo implements Serializable {
    public float posToCenterDistance;

    public CarHWInfo() {
        this.posToCenterDistance = -1.0f;
    }

    public CarHWInfo(float f) {
        this.posToCenterDistance = f;
    }
}

package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ElecSpeedCostList implements Serializable {
    public float costValue;
    public int speed;

    public ElecSpeedCostList() {
        this.speed = 0;
        this.costValue = 0.0f;
    }

    public ElecSpeedCostList(int i, float f) {
        this.speed = i;
        this.costValue = f;
    }
}

package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DistanceRange implements Serializable {
    public int max;
    public int min;

    public DistanceRange() {
        this.min = 0;
        this.max = 0;
    }

    public DistanceRange(int i, int i2) {
        this.min = i;
        this.max = i2;
    }
}

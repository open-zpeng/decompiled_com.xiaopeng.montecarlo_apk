package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TimeAndDist implements Serializable {
    public int dist;
    public int time;

    public TimeAndDist() {
        this.time = 0;
        this.dist = 0;
    }

    public TimeAndDist(int i, int i2) {
        this.time = i;
        this.dist = i2;
    }
}

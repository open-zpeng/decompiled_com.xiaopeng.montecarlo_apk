package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TmcInfoData implements Serializable {
    public int distance;
    public int number;
    public float percent;
    public int status;
    public int travelTime;

    public TmcInfoData() {
        this.number = 0;
        this.status = 0;
        this.distance = 0;
        this.percent = 0.0f;
        this.travelTime = 0;
    }

    public TmcInfoData(int i, int i2, int i3, float f, int i4) {
        this.number = i;
        this.status = i2;
        this.distance = i3;
        this.percent = f;
        this.travelTime = i4;
    }
}

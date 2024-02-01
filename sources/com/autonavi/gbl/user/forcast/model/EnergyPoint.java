package com.autonavi.gbl.user.forcast.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class EnergyPoint implements Serializable {
    public float fPercent;
    public float fPower;
    public int nMileage;
    public long nTimeStamp;

    public EnergyPoint() {
        this.nMileage = 0;
        this.fPower = 0.0f;
        this.fPercent = 0.0f;
        this.nTimeStamp = 0L;
    }

    public EnergyPoint(int i, float f, float f2, long j) {
        this.nMileage = i;
        this.fPower = f;
        this.fPercent = f2;
        this.nTimeStamp = j;
    }
}

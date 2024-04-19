package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ParkExtInfo implements Serializable {
    public double capFee;
    public int parkDuration;

    public ParkExtInfo() {
        this.capFee = 0.0d;
        this.parkDuration = 0;
    }

    public ParkExtInfo(double d, int i) {
        this.capFee = d;
        this.parkDuration = i;
    }
}

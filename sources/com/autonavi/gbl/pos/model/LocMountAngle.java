package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocMountAngle implements Serializable {
    public boolean isValid;
    public double pitch;
    public double roll;
    public double yaw;

    public LocMountAngle() {
        this.isValid = false;
        this.yaw = 0.0d;
        this.pitch = 0.0d;
        this.roll = 0.0d;
    }

    public LocMountAngle(boolean z, double d, double d2, double d3) {
        this.isValid = z;
        this.yaw = d;
        this.pitch = d2;
        this.roll = d3;
    }
}

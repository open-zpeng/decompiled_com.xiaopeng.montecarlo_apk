package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CruiseTimeAndDist implements Serializable {
    public int driveDist;
    public int driveTime;

    public CruiseTimeAndDist() {
        this.driveTime = 0;
        this.driveDist = 0;
    }

    public CruiseTimeAndDist(int i, int i2) {
        this.driveTime = i;
        this.driveDist = i2;
    }
}

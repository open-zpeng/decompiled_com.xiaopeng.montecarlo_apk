package com.autonavi.gbl.pos.model;

import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class NgmDiff implements Serializable {
    public float dx;
    public float dy;
    public int flag;
    public BigInteger gpsTickTime;
    public float heading;
    public int isRerouting;

    public NgmDiff() {
        this.gpsTickTime = new BigInteger("0");
        this.dx = 0.0f;
        this.dy = 0.0f;
        this.heading = 0.0f;
        this.isRerouting = 0;
        this.flag = 0;
    }

    public NgmDiff(BigInteger bigInteger, float f, float f2, float f3, int i, int i2) {
        this.gpsTickTime = bigInteger;
        this.dx = f;
        this.dy = f2;
        this.heading = f3;
        this.isRerouting = i;
        this.flag = i2;
    }
}

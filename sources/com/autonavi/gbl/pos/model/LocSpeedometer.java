package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocSpeedometer implements Serializable {
    @LocDataType.LocDataType1
    public int dataType;
    public int interval;
    public BigInteger tickTime;
    public float value;

    public LocSpeedometer() {
        this.dataType = Integer.MIN_VALUE;
        this.value = 0.0f;
        this.interval = 0;
        this.tickTime = new BigInteger("0");
    }

    public LocSpeedometer(@LocDataType.LocDataType1 int i, float f, int i2, BigInteger bigInteger) {
        this.dataType = i;
        this.value = f;
        this.interval = i2;
        this.tickTime = bigInteger;
    }
}

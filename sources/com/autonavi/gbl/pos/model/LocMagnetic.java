package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocThreeAxis;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocMagnetic implements Serializable {
    @LocThreeAxis.LocThreeAxis1
    public int axis;
    @LocDataType.LocDataType1
    public int dataType;
    public int interval;
    public float magX;
    public float magY;
    public float magZ;
    public BigInteger tickTime;

    public LocMagnetic() {
        this.dataType = 65536;
        this.axis = 0;
        this.interval = 0;
        this.magZ = 0.0f;
        this.magX = 0.0f;
        this.magY = 0.0f;
        this.tickTime = new BigInteger("0");
    }

    public LocMagnetic(@LocDataType.LocDataType1 int i, @LocThreeAxis.LocThreeAxis1 int i2, int i3, float f, float f2, float f3, BigInteger bigInteger) {
        this.dataType = i;
        this.axis = i2;
        this.interval = i3;
        this.magZ = f;
        this.magX = f2;
        this.magY = f3;
        this.tickTime = bigInteger;
    }
}

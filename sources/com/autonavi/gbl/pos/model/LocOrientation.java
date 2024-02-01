package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocThreeAxis;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocOrientation implements Serializable {
    @LocThreeAxis.LocThreeAxis1
    public int axis;
    @LocDataType.LocDataType1
    public int dataType;
    public int interval;
    public float ortX;
    public float ortY;
    public float ortZ;
    public BigInteger tickTime;

    public LocOrientation() {
        this.dataType = 131072;
        this.axis = 0;
        this.interval = 0;
        this.ortZ = 0.0f;
        this.ortX = 0.0f;
        this.ortY = 0.0f;
        this.tickTime = new BigInteger("0");
    }

    public LocOrientation(@LocDataType.LocDataType1 int i, @LocThreeAxis.LocThreeAxis1 int i2, int i3, float f, float f2, float f3, BigInteger bigInteger) {
        this.dataType = i;
        this.axis = i2;
        this.interval = i3;
        this.ortZ = f;
        this.ortX = f2;
        this.ortY = f3;
        this.tickTime = bigInteger;
    }
}

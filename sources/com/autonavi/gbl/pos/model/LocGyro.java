package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocThreeAxis;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocGyro implements Serializable {
    @LocThreeAxis.LocThreeAxis1
    public int axis;
    @LocDataType.LocDataType1
    public int dataType;
    public int interval;
    public float temperature;
    public BigInteger tickTime;
    public float valueX;
    public float valueY;
    public float valueZ;

    public LocGyro() {
        this.dataType = 4;
        this.axis = 4;
        this.valueZ = 0.0f;
        this.valueX = 0.0f;
        this.valueY = 0.0f;
        this.temperature = 0.0f;
        this.interval = 0;
        this.tickTime = new BigInteger("0");
    }

    public LocGyro(@LocDataType.LocDataType1 int i, @LocThreeAxis.LocThreeAxis1 int i2, float f, float f2, float f3, float f4, int i3, BigInteger bigInteger) {
        this.dataType = i;
        this.axis = i2;
        this.valueZ = f;
        this.valueX = f2;
        this.valueY = f3;
        this.temperature = f4;
        this.interval = i3;
        this.tickTime = bigInteger;
    }
}

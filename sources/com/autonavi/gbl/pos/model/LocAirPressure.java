package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocAirPressure implements Serializable {
    @LocDataType.LocDataType1
    public int dataType;
    public float hpa;
    public BigInteger tickTime;

    public LocAirPressure() {
        this.dataType = 32;
        this.hpa = 0.0f;
        this.tickTime = new BigInteger("0");
    }

    public LocAirPressure(@LocDataType.LocDataType1 int i, float f, BigInteger bigInteger) {
        this.dataType = i;
        this.hpa = f;
        this.tickTime = bigInteger;
    }
}

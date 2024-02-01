package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocThreeAxis;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocAcce3d implements Serializable {
    public float acceX;
    public float acceY;
    public float acceZ;
    @LocThreeAxis.LocThreeAxis1
    public int axis;
    @LocDataType.LocDataType1
    public int dataType;
    public int interval;
    public BigInteger tickTime;

    public LocAcce3d() {
        this.dataType = 2;
        this.axis = 4;
        this.acceZ = 0.0f;
        this.acceX = 0.0f;
        this.acceY = 0.0f;
        this.interval = 0;
        this.tickTime = new BigInteger("0");
    }

    public LocAcce3d(@LocDataType.LocDataType1 int i, @LocThreeAxis.LocThreeAxis1 int i2, float f, float f2, float f3, int i3, BigInteger bigInteger) {
        this.dataType = i;
        this.axis = i2;
        this.acceZ = f;
        this.acceX = f2;
        this.acceY = f3;
        this.interval = i3;
        this.tickTime = bigInteger;
    }
}

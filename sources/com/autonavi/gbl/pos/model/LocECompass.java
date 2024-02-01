package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocECompass implements Serializable {
    public float azi;
    @LocDataType.LocDataType1
    public int dataType;
    public byte deviceAttitude;
    public BigInteger tickTime;

    public LocECompass() {
        this.dataType = 1;
        this.deviceAttitude = (byte) 0;
        this.azi = 0.0f;
        this.tickTime = new BigInteger("0");
    }

    public LocECompass(@LocDataType.LocDataType1 int i, byte b, float f, BigInteger bigInteger) {
        this.dataType = i;
        this.deviceAttitude = b;
        this.azi = f;
        this.tickTime = bigInteger;
    }
}

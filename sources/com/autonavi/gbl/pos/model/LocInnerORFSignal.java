package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocInnerORFSignal implements Serializable {
    public float aziX;
    public float aziY;
    public float aziZ;
    @LocDataType.LocDataType1
    public int dataType;
    public BigInteger tickTime;
    public BigInteger utcTime;

    public LocInnerORFSignal() {
        this.dataType = 0;
        this.tickTime = new BigInteger("0");
        this.utcTime = new BigInteger("0");
        this.aziX = 0.0f;
        this.aziY = 0.0f;
        this.aziZ = 0.0f;
    }

    public LocInnerORFSignal(@LocDataType.LocDataType1 int i, BigInteger bigInteger, BigInteger bigInteger2, float f, float f2, float f3) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.utcTime = bigInteger2;
        this.aziX = f;
        this.aziY = f2;
        this.aziZ = f3;
    }
}

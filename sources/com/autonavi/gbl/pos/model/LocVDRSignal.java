package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocVDRSignal implements Serializable {
    public float azi;
    public float confidence;
    @LocDataType.LocDataType1
    public int dataType;
    public float deltaBearing;
    public int interval;
    public BigInteger localTickTime;
    public BigInteger tickTime;

    public LocVDRSignal() {
        this.dataType = 16777216;
        this.tickTime = new BigInteger("0");
        this.localTickTime = new BigInteger("0");
        this.azi = 0.0f;
        this.deltaBearing = 0.0f;
        this.confidence = 0.0f;
        this.interval = 0;
    }

    public LocVDRSignal(@LocDataType.LocDataType1 int i, BigInteger bigInteger, BigInteger bigInteger2, float f, float f2, float f3, int i2) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.localTickTime = bigInteger2;
        this.azi = f;
        this.deltaBearing = f2;
        this.confidence = f3;
        this.interval = i2;
    }
}

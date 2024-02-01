package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.xiaopeng.montecarlo.navcore.location.GnssLocation;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class PosFusionResultExternal implements Serializable {
    public byte EW;
    public byte NS;
    public float posAcc;
    public Coord3DDouble posRaw;
    public byte status;
    public BigInteger tickTime;

    public PosFusionResultExternal() {
        this.tickTime = new BigInteger("0");
        this.status = GnssLocation.LOC_INVALID;
        this.NS = (byte) 78;
        this.EW = (byte) 69;
        this.posRaw = new Coord3DDouble();
        this.posAcc = 0.0f;
    }

    public PosFusionResultExternal(BigInteger bigInteger, byte b, byte b2, byte b3, Coord3DDouble coord3DDouble, float f) {
        this.tickTime = bigInteger;
        this.status = b;
        this.NS = b2;
        this.EW = b3;
        this.posRaw = coord3DDouble;
        this.posAcc = f;
    }
}

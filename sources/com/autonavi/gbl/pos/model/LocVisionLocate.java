package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocVisionLocate implements Serializable {
    public float azi;
    public float aziAcc;
    @LocDataType.LocDataType1
    public int dataType;
    public BigInteger localTickTime;
    public Coord3DDouble pos;
    public float posAcc;
    public int state;
    public BigInteger tickTime;

    public LocVisionLocate() {
        this.dataType = 1073741824;
        this.pos = new Coord3DDouble();
        this.azi = 0.0f;
        this.posAcc = 0.0f;
        this.aziAcc = 0.0f;
        this.state = 0;
        this.tickTime = new BigInteger("0");
        this.localTickTime = new BigInteger("0");
    }

    public LocVisionLocate(@LocDataType.LocDataType1 int i, Coord3DDouble coord3DDouble, float f, float f2, float f3, int i2, BigInteger bigInteger, BigInteger bigInteger2) {
        this.dataType = i;
        this.pos = coord3DDouble;
        this.azi = f;
        this.posAcc = f2;
        this.aziAcc = f3;
        this.state = i2;
        this.tickTime = bigInteger;
        this.localTickTime = bigInteger2;
    }
}

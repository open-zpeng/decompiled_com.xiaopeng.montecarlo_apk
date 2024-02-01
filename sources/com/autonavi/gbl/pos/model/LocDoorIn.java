package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocDoorIn implements Serializable {
    @LocDataType.LocDataType1
    public int dataType;
    public short[] floor;
    public short[] poiId;
    public Coord3DDouble stPt;
    public BigInteger tickTime;

    public LocDoorIn() {
        this.dataType = 128;
        this.stPt = new Coord3DDouble();
        this.tickTime = new BigInteger("0");
        this.poiId = new short[32];
        this.floor = new short[32];
    }

    public LocDoorIn(@LocDataType.LocDataType1 int i, Coord3DDouble coord3DDouble, short[] sArr, short[] sArr2, BigInteger bigInteger) {
        this.dataType = i;
        this.stPt = coord3DDouble;
        this.poiId = sArr;
        this.floor = sArr2;
        this.tickTime = bigInteger;
    }
}

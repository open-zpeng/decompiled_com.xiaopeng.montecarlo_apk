package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocGpgsv implements Serializable {
    public int[] azimuth;
    @LocDataType.LocDataType1
    public int dataType;
    public int[] elevation;
    public int num;
    public int[] prn;
    public int[] snr;
    public BigInteger tickTime;
    public int type;

    public LocGpgsv() {
        this.dataType = 64;
        this.type = 0;
        this.num = 0;
        this.tickTime = new BigInteger("0");
        this.prn = new int[16];
        this.elevation = new int[16];
        this.azimuth = new int[16];
        this.snr = new int[16];
    }

    public LocGpgsv(@LocDataType.LocDataType1 int i, int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, BigInteger bigInteger) {
        this.dataType = i;
        this.type = i2;
        this.num = i3;
        this.prn = iArr;
        this.elevation = iArr2;
        this.azimuth = iArr3;
        this.snr = iArr4;
        this.tickTime = bigInteger;
    }
}

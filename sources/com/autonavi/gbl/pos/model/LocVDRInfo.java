package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocVDRInfo implements Serializable {
    public float confidence;
    public float course;
    @LocDataType.LocDataType1
    public int dataType;
    public BigInteger localTickTime;
    public Coord3DDouble pos;
    public double[] quatCW;
    public double[] quatIW;
    public float speed;
    public BigInteger tickTime;

    public LocVDRInfo() {
        this.dataType = LocDataType.LocDataVDRInfo;
        this.tickTime = new BigInteger("0");
        this.pos = new Coord3DDouble();
        this.course = 0.0f;
        this.speed = 0.0f;
        this.confidence = 0.0f;
        this.localTickTime = new BigInteger("0");
        this.quatIW = new double[4];
        double[] dArr = this.quatIW;
        dArr[0] = 0.0d;
        dArr[1] = 0.0d;
        dArr[2] = 0.0d;
        dArr[3] = 0.0d;
        this.quatCW = new double[4];
        double[] dArr2 = this.quatCW;
        dArr2[0] = 0.0d;
        dArr2[1] = 0.0d;
        dArr2[2] = 0.0d;
        dArr2[3] = 0.0d;
    }

    public LocVDRInfo(@LocDataType.LocDataType1 int i, BigInteger bigInteger, Coord3DDouble coord3DDouble, float f, float f2, float f3, double[] dArr, double[] dArr2, BigInteger bigInteger2) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.pos = coord3DDouble;
        this.course = f;
        this.speed = f2;
        this.confidence = f3;
        this.quatIW = dArr;
        this.quatCW = dArr2;
        this.localTickTime = bigInteger2;
    }
}

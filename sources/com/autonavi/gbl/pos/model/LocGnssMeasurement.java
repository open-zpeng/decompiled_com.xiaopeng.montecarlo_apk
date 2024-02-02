package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LocGnssMeasurement implements Serializable {
    @LocDataType.LocDataType1
    public int dataType;
    public GnssClock gnssClockObj;
    public BigInteger localTickTime;
    public int measurementListCnt;
    public ArrayList<GnssMeasurementObj> measurementObjList;
    public BigInteger tickTime;

    public LocGnssMeasurement() {
        this.dataType = 0;
        this.tickTime = new BigInteger("0");
        this.localTickTime = new BigInteger("0");
        this.measurementObjList = new ArrayList<>();
        this.measurementListCnt = 0;
        this.gnssClockObj = new GnssClock();
    }

    public LocGnssMeasurement(@LocDataType.LocDataType1 int i, BigInteger bigInteger, BigInteger bigInteger2, ArrayList<GnssMeasurementObj> arrayList, int i2, GnssClock gnssClock) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.localTickTime = bigInteger2;
        this.measurementObjList = arrayList;
        this.measurementListCnt = i2;
        this.gnssClockObj = gnssClock;
    }
}

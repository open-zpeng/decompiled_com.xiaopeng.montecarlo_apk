package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocDriveComfort implements Serializable {
    @LocDataType.LocDataType1
    public int dataType;
    public double statusComfortIndex;
    public double statusEndLatitude;
    public double statusEndLongitude;
    public BigInteger statusEndTime;
    public double statusStartLatitude;
    public double statusStartLongitude;
    public BigInteger statusStartTime;

    public LocDriveComfort() {
        this.dataType = 16384;
        this.statusComfortIndex = 0.0d;
        this.statusStartLatitude = 0.0d;
        this.statusStartLongitude = 0.0d;
        this.statusEndLatitude = 0.0d;
        this.statusEndLongitude = 0.0d;
        this.statusStartTime = new BigInteger("0");
        this.statusEndTime = new BigInteger("0");
    }

    public LocDriveComfort(@LocDataType.LocDataType1 int i, double d, double d2, double d3, double d4, double d5, BigInteger bigInteger, BigInteger bigInteger2) {
        this.dataType = i;
        this.statusComfortIndex = d;
        this.statusStartLatitude = d2;
        this.statusStartLongitude = d3;
        this.statusEndLatitude = d4;
        this.statusEndLongitude = d5;
        this.statusStartTime = bigInteger;
        this.statusEndTime = bigInteger2;
    }
}

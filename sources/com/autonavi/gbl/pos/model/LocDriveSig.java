package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocDriveSig implements Serializable {
    public double[] accelerations;
    @LocDataType.LocDataType1
    public int dataType;
    public double heading;
    public double[] magneticField;
    public double[] rotationRates;
    public double uptime;

    public LocDriveSig() {
        this.dataType = 4096;
        this.heading = 0.0d;
        this.uptime = 0.0d;
        this.accelerations = new double[3];
        this.rotationRates = new double[3];
        this.magneticField = new double[3];
    }

    public LocDriveSig(@LocDataType.LocDataType1 int i, double d, double d2, double[] dArr, double[] dArr2, double[] dArr3) {
        this.dataType = i;
        this.heading = d;
        this.uptime = d2;
        this.accelerations = dArr;
        this.rotationRates = dArr2;
        this.magneticField = dArr3;
    }
}

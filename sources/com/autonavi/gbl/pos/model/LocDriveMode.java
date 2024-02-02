package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocDriveMode implements Serializable {
    public float compassHeading;
    @LocDataType.LocDataType1
    public int dataType;
    public long driveMode;
    public float fusionedHeading;
    public BigInteger tickTime;

    public LocDriveMode() {
        this.dataType = 1024;
        this.driveMode = 0L;
        this.fusionedHeading = 0.0f;
        this.compassHeading = 0.0f;
        this.tickTime = new BigInteger("0");
    }

    public LocDriveMode(@LocDataType.LocDataType1 int i, long j, float f, float f2, BigInteger bigInteger) {
        this.dataType = i;
        this.driveMode = j;
        this.fusionedHeading = f;
        this.compassHeading = f2;
        this.tickTime = bigInteger;
    }
}

package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocEventSensorType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocDriveEvent implements Serializable {
    @LocDataType.LocDataType1
    public int dataType;
    public BigInteger eventEndTime;
    public double eventLatitude;
    public double eventLevel;
    public double eventLongitude;
    public double eventMaxAcc;
    public double eventMaxSpeed;
    @LocEventSensorType.LocEventSensorType1
    public int eventSensorMode;
    public BigInteger eventStartTime;
    public int eventType;

    public LocDriveEvent() {
        this.dataType = 8192;
        this.eventType = 0;
        this.eventLevel = 0.0d;
        this.eventLatitude = 0.0d;
        this.eventLongitude = 0.0d;
        this.eventStartTime = new BigInteger("0");
        this.eventEndTime = new BigInteger("0");
        this.eventMaxSpeed = 0.0d;
        this.eventMaxAcc = 0.0d;
        this.eventSensorMode = 0;
    }

    public LocDriveEvent(@LocDataType.LocDataType1 int i, int i2, double d, double d2, double d3, BigInteger bigInteger, BigInteger bigInteger2, double d4, double d5, @LocEventSensorType.LocEventSensorType1 int i3) {
        this.dataType = i;
        this.eventType = i2;
        this.eventLevel = d;
        this.eventLatitude = d2;
        this.eventLongitude = d3;
        this.eventStartTime = bigInteger;
        this.eventEndTime = bigInteger2;
        this.eventMaxSpeed = d4;
        this.eventMaxAcc = d5;
        this.eventSensorMode = i3;
    }
}

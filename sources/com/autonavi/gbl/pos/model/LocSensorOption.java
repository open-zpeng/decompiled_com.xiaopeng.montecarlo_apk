package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocSensorOption implements Serializable {
    public int accFreq;
    public int gpsFreq;
    public int gyroFreq;
    public int hasAcc;
    public int hasGsv;
    public int hasGyro;
    public int hasMag;
    public int hasPressure;
    public int hasTemp;
    public int hasW4m;
    public int pulseFreq;
    public int w4mFreq;

    public LocSensorOption() {
        this.hasAcc = 0;
        this.hasGyro = 0;
        this.hasTemp = 0;
        this.hasPressure = 0;
        this.hasMag = 0;
        this.hasW4m = 0;
        this.hasGsv = 1;
        this.pulseFreq = 0;
        this.gyroFreq = 0;
        this.gpsFreq = 0;
        this.accFreq = 0;
        this.w4mFreq = 0;
    }

    public LocSensorOption(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.hasAcc = i;
        this.hasGyro = i2;
        this.hasTemp = i3;
        this.hasPressure = i4;
        this.hasMag = i5;
        this.hasW4m = i6;
        this.hasGsv = i7;
        this.pulseFreq = i8;
        this.gyroFreq = i9;
        this.gpsFreq = i10;
        this.accFreq = i11;
        this.w4mFreq = i12;
    }
}

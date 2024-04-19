package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ChargingPlugInfo implements Serializable {
    public int fastCurrent;
    public int fastPower;
    public int fastVoltage;
    public int plugType;
    public int slowCurrent;
    public int slowPower;
    public int slowVoltage;

    public ChargingPlugInfo() {
        this.plugType = 0;
        this.fastVoltage = 0;
        this.fastCurrent = 0;
        this.fastPower = 0;
        this.slowVoltage = 0;
        this.slowCurrent = 0;
        this.slowPower = 0;
    }

    public ChargingPlugInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.plugType = i;
        this.fastVoltage = i2;
        this.fastCurrent = i3;
        this.fastPower = i4;
        this.slowVoltage = i5;
        this.slowCurrent = i6;
        this.slowPower = i7;
    }
}

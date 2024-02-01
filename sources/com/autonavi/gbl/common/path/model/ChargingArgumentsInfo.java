package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChargingArgumentsInfo implements Serializable {
    public long amperage;
    public short minArrivalPercent;
    public long power;
    public short type;
    public long voltage;

    public ChargingArgumentsInfo() {
        this.type = (short) 2;
        this.minArrivalPercent = (short) 0;
        this.power = 0L;
        this.voltage = 0L;
        this.amperage = 0L;
    }

    public ChargingArgumentsInfo(short s, short s2, long j, long j2, long j3) {
        this.type = s;
        this.minArrivalPercent = s2;
        this.power = j;
        this.voltage = j2;
        this.amperage = j3;
    }
}

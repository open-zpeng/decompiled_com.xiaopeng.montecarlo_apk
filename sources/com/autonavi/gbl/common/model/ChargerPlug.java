package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChargerPlug implements Serializable {
    public long maximumPower;
    public long type;

    public ChargerPlug() {
        this.type = 0L;
        this.maximumPower = 0L;
    }

    public ChargerPlug(long j, long j2) {
        this.type = j;
        this.maximumPower = j2;
    }
}

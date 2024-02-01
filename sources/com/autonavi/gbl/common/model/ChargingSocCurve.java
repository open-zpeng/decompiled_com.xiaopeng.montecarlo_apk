package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChargingSocCurve implements Serializable {
    public long power;
    public long soc;

    public ChargingSocCurve() {
        this.soc = 0L;
        this.power = 0L;
    }

    public ChargingSocCurve(long j, long j2) {
        this.soc = j;
        this.power = j2;
    }
}

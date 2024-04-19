package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ExitInfo implements Serializable {
    public double lat;
    public double lon;
    public long x;
    public long y;

    public ExitInfo() {
        this.x = 0L;
        this.y = 0L;
        this.lon = 0.0d;
        this.lat = 0.0d;
    }

    public ExitInfo(long j, long j2, double d, double d2) {
        this.x = j;
        this.y = j2;
        this.lon = d;
        this.lat = d2;
    }
}

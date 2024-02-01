package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LightState implements Serializable {
    public long etime;
    public long stime;
    public int type;

    public LightState() {
        this.type = 0;
        this.stime = 0L;
        this.etime = 0L;
    }

    public LightState(int i, long j, long j2) {
        this.type = i;
        this.stime = j;
        this.etime = j2;
    }
}

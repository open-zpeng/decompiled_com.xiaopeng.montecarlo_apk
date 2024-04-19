package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GDataTime implements Serializable {
    public GDate date;
    public GTime time;

    public GDataTime() {
        this.date = new GDate();
        this.time = new GTime();
    }

    public GDataTime(GDate gDate, GTime gTime) {
        this.date = gDate;
        this.time = gTime;
    }
}

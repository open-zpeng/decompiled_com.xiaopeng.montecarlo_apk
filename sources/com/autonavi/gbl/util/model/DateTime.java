package com.autonavi.gbl.util.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DateTime implements Serializable {
    public Date date;
    public Time time;

    public DateTime() {
        this.date = new Date();
        this.time = new Time();
    }

    public DateTime(Date date, Time time) {
        this.date = date;
        this.time = time;
    }
}

package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TimeRangeBl implements Serializable {
    public short day;
    public short hour;
    public short min;
    public short month;
    public short week;
    public short year;

    public TimeRangeBl() {
        this.min = (short) 0;
        this.hour = (short) 0;
        this.week = (short) 0;
        this.day = (short) 0;
        this.month = (short) 0;
        this.year = (short) 0;
    }

    public TimeRangeBl(short s, short s2, short s3, short s4, short s5, short s6) {
        this.min = s;
        this.hour = s2;
        this.week = s3;
        this.day = s4;
        this.month = s5;
        this.year = s6;
    }
}

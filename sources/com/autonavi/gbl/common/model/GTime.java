package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GTime implements Serializable {
    public short hour;
    public short minute;
    public short reserved;
    public short second;

    public GTime() {
        this.hour = (short) 0;
        this.minute = (short) 0;
        this.second = (short) 0;
        this.reserved = (short) 0;
    }

    public GTime(short s, short s2, short s3, short s4) {
        this.hour = s;
        this.minute = s2;
        this.second = s3;
        this.reserved = s4;
    }
}

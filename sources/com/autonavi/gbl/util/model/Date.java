package com.autonavi.gbl.util.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Date implements Serializable {
    public byte day;
    public byte month;
    public byte week;
    public short year;

    public Date() {
        this.year = (short) 0;
        this.month = (byte) 0;
        this.day = (byte) 0;
        this.week = (byte) 0;
    }

    public Date(short s, byte b, byte b2, byte b3) {
        this.year = s;
        this.month = b;
        this.day = b2;
        this.week = b3;
    }
}

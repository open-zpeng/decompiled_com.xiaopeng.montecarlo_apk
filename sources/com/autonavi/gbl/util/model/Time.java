package com.autonavi.gbl.util.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Time implements Serializable {
    public byte hour;
    public byte minute;
    public byte reserved;
    public byte second;

    public Time() {
        this.hour = (byte) 0;
        this.minute = (byte) 0;
        this.second = (byte) 0;
        this.reserved = (byte) 0;
    }

    public Time(byte b, byte b2, byte b3, byte b4) {
        this.hour = b;
        this.minute = b2;
        this.second = b3;
        this.reserved = b4;
    }
}

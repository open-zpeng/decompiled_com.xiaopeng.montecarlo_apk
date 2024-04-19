package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GDate implements Serializable {
    public short day;
    public short month;
    public int year;

    public GDate() {
        this.year = 0;
        this.month = (short) 0;
        this.day = (short) 0;
    }

    public GDate(int i, short s, short s2) {
        this.year = i;
        this.month = s;
        this.day = s2;
    }
}

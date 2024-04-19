package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapParameter implements Serializable {
    public long value;
    public int value1;
    public int value2;
    public int value3;
    public int value4;

    public MapParameter() {
        this.value1 = 0;
        this.value2 = 0;
        this.value3 = 0;
        this.value4 = 0;
        this.value = 0L;
    }

    public MapParameter(int i, int i2, int i3, int i4, long j) {
        this.value1 = i;
        this.value2 = i2;
        this.value3 = i3;
        this.value4 = i4;
        this.value = j;
    }
}

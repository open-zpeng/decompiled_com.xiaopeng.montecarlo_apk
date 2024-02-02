package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ScreenShotParam implements Serializable {
    public long pointerValue;
    public int value1;
    public int value2;
    public int value3;
    public int value4;

    public ScreenShotParam() {
        this.pointerValue = 0L;
        this.value1 = 0;
        this.value2 = 0;
        this.value3 = 0;
        this.value4 = 0;
    }

    public ScreenShotParam(long j, int i, int i2, int i3, int i4) {
        this.pointerValue = j;
        this.value1 = i;
        this.value2 = i2;
        this.value3 = i3;
        this.value4 = i4;
    }
}

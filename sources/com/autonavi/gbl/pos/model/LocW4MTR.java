package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocW4MTR implements Serializable {
    @LocDataType.LocDataType1
    public int dataType;
    public int interval;
    public float psFL;
    public float psFR;
    public float psRL;
    public float psRR;
    public float teFL;
    public float teFR;
    public float teRL;
    public float teRR;
    public long tickTime;

    public LocW4MTR() {
        this.dataType = 2048;
        this.psRL = 0.0f;
        this.psRR = 0.0f;
        this.psFL = 0.0f;
        this.psFR = 0.0f;
        this.teRL = 0.0f;
        this.teRR = 0.0f;
        this.teFL = 0.0f;
        this.teFR = 0.0f;
        this.interval = 0;
        this.tickTime = 0L;
    }

    public LocW4MTR(@LocDataType.LocDataType1 int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2, long j) {
        this.dataType = i;
        this.psRL = f;
        this.psRR = f2;
        this.psFL = f3;
        this.psFR = f4;
        this.teRL = f5;
        this.teRR = f6;
        this.teFL = f7;
        this.teFR = f8;
        this.interval = i2;
        this.tickTime = j;
    }
}

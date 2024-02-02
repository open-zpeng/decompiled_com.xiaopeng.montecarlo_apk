package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocGearState;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocW4M implements Serializable {
    @LocDataType.LocDataType1
    public int dataType;
    @LocGearState.LocGearState1
    public int gearState;
    public int interval;
    public float latAcc;
    public float lonAcc;
    public float offLatA;
    public float offLonA;
    public float offYR;
    public float pfl;
    public float pfr;
    public float prl;
    public float prr;
    public float steerAngle;
    public long tickTime;
    public float vfl;
    public float vfr;
    public float vrl;
    public float vrr;
    public float yawRate;

    public LocW4M() {
        this.dataType = 256;
        this.vrl = 0.0f;
        this.vrr = 0.0f;
        this.vfl = 0.0f;
        this.vfr = 0.0f;
        this.steerAngle = 0.0f;
        this.yawRate = 0.0f;
        this.lonAcc = 0.0f;
        this.latAcc = 0.0f;
        this.gearState = 0;
        this.interval = 0;
        this.tickTime = 0L;
        this.prl = 0.0f;
        this.prr = 0.0f;
        this.pfl = 0.0f;
        this.pfr = 0.0f;
        this.offYR = 0.0f;
        this.offLonA = 0.0f;
        this.offLatA = 0.0f;
    }

    public LocW4M(@LocDataType.LocDataType1 int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, @LocGearState.LocGearState1 int i2, int i3, long j, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        this.dataType = i;
        this.vrl = f;
        this.vrr = f2;
        this.vfl = f3;
        this.vfr = f4;
        this.steerAngle = f5;
        this.yawRate = f6;
        this.lonAcc = f7;
        this.latAcc = f8;
        this.gearState = i2;
        this.interval = i3;
        this.tickTime = j;
        this.prl = f9;
        this.prr = f10;
        this.pfl = f11;
        this.pfr = f12;
        this.offYR = f13;
        this.offLonA = f14;
        this.offLatA = f15;
    }
}

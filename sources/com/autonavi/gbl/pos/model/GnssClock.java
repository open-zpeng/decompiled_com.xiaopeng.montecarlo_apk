package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GnssClock implements Serializable {
    public float biasNanos;
    public float biasUncertaintyNanos;
    public float driftNanosPerSecond;
    public float driftUncertaintyNanosPerSecond;
    public long elapsedRealtimeNanos;
    public float elapsedRealtimeUncertaintyNanos;
    public long fullBiasNanos;
    public int hardwareClockDiscontinuityCount;
    public short leapSecond;
    public long timeNanos;
    public float timeUncertaintyNanos;

    public GnssClock() {
        this.elapsedRealtimeNanos = 0L;
        this.fullBiasNanos = 0L;
        this.timeNanos = 0L;
        this.biasNanos = 0.0f;
        this.biasUncertaintyNanos = 0.0f;
        this.driftNanosPerSecond = 0.0f;
        this.driftUncertaintyNanosPerSecond = 0.0f;
        this.elapsedRealtimeUncertaintyNanos = 0.0f;
        this.timeUncertaintyNanos = 0.0f;
        this.hardwareClockDiscontinuityCount = 0;
        this.leapSecond = (short) 0;
    }

    public GnssClock(long j, long j2, long j3, float f, float f2, float f3, float f4, float f5, float f6, int i, short s) {
        this.elapsedRealtimeNanos = j;
        this.fullBiasNanos = j2;
        this.timeNanos = j3;
        this.biasNanos = f;
        this.biasUncertaintyNanos = f2;
        this.driftNanosPerSecond = f3;
        this.driftUncertaintyNanosPerSecond = f4;
        this.elapsedRealtimeUncertaintyNanos = f5;
        this.timeUncertaintyNanos = f6;
        this.hardwareClockDiscontinuityCount = i;
        this.leapSecond = s;
    }
}

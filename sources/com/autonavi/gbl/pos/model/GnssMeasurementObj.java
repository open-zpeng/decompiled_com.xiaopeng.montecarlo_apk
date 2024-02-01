package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GnssMeasurementObj implements Serializable {
    public float accumulatedDeltaRangeMeters;
    public byte accumulatedDeltaRangeState;
    public float accumulatedDeltaRangeUncertaintyMeters;
    public float automaticGainControlLevelDb;
    public float carrierFrequencyHz;
    public float cn0DbHz;
    public byte codeType;
    public byte constellationType;
    public byte multipathIndicator;
    public float pseudorangeRateMetersPerSecond;
    public float pseudorangeRateUncertaintyMetersPerSecond;
    public long receivedSvTimeNanos;
    public long receivedSvTimeUncertaintyNanos;
    public float snrInDb;
    public int state;
    public short svid;
    public float timeOffsetNanos;

    public GnssMeasurementObj() {
        this.receivedSvTimeNanos = 0L;
        this.receivedSvTimeUncertaintyNanos = 0L;
        this.accumulatedDeltaRangeMeters = 0.0f;
        this.accumulatedDeltaRangeUncertaintyMeters = 0.0f;
        this.automaticGainControlLevelDb = 0.0f;
        this.carrierFrequencyHz = 0.0f;
        this.cn0DbHz = 0.0f;
        this.pseudorangeRateMetersPerSecond = 0.0f;
        this.pseudorangeRateUncertaintyMetersPerSecond = 0.0f;
        this.snrInDb = 0.0f;
        this.timeOffsetNanos = 0.0f;
        this.state = 0;
        this.svid = (short) 0;
        this.accumulatedDeltaRangeState = (byte) 0;
        this.codeType = (byte) 0;
        this.constellationType = (byte) 0;
        this.multipathIndicator = (byte) 0;
    }

    public GnssMeasurementObj(long j, long j2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, short s, byte b, byte b2, byte b3, byte b4) {
        this.receivedSvTimeNanos = j;
        this.receivedSvTimeUncertaintyNanos = j2;
        this.accumulatedDeltaRangeMeters = f;
        this.accumulatedDeltaRangeUncertaintyMeters = f2;
        this.automaticGainControlLevelDb = f3;
        this.carrierFrequencyHz = f4;
        this.cn0DbHz = f5;
        this.pseudorangeRateMetersPerSecond = f6;
        this.pseudorangeRateUncertaintyMetersPerSecond = f7;
        this.snrInDb = f8;
        this.timeOffsetNanos = f9;
        this.state = i;
        this.svid = s;
        this.accumulatedDeltaRangeState = b;
        this.codeType = b2;
        this.constellationType = b3;
        this.multipathIndicator = b4;
    }
}

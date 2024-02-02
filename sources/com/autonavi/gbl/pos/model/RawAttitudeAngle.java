package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RawAttitudeAngle implements Serializable {
    public double rollValue;
    public double slopeValue;
    public boolean validRollValue;
    public boolean validSlopeValue;

    public RawAttitudeAngle() {
        this.validSlopeValue = false;
        this.validRollValue = false;
        this.slopeValue = 0.0d;
        this.rollValue = 0.0d;
    }

    public RawAttitudeAngle(boolean z, boolean z2, double d, double d2) {
        this.validSlopeValue = z;
        this.validRollValue = z2;
        this.slopeValue = d;
        this.rollValue = d2;
    }
}

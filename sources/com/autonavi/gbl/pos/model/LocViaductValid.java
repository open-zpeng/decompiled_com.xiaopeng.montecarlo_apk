package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocViaductValid implements Serializable {
    public boolean deltaAlt;
    public boolean deltaAltAcc;
    public boolean moveDist;
    public boolean slopeAcc;
    public boolean slopeValue;

    public LocViaductValid() {
        this.deltaAlt = false;
        this.deltaAltAcc = false;
        this.slopeValue = false;
        this.slopeAcc = false;
        this.moveDist = false;
    }

    public LocViaductValid(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.deltaAlt = z;
        this.deltaAltAcc = z2;
        this.slopeValue = z3;
        this.slopeAcc = z4;
        this.moveDist = z5;
    }
}

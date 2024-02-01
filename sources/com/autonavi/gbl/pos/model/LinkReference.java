package com.autonavi.gbl.pos.model;

import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LinkReference implements Serializable {
    public BigInteger linkId;
    public float offsetLon;
    public boolean positiveDir;

    public LinkReference() {
        this.linkId = new BigInteger("0");
        this.offsetLon = 0.0f;
        this.positiveDir = false;
    }

    public LinkReference(BigInteger bigInteger, float f, boolean z) {
        this.linkId = bigInteger;
        this.offsetLon = f;
        this.positiveDir = z;
    }
}

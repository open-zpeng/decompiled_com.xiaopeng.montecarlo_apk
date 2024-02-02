package com.autonavi.gbl.pos.model;

import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LaneFusionResultExternal implements Serializable {
    public byte indices;
    public float lateralOffsetLeft;
    public float lateralOffsetLeftAcc;
    public float lateralOffsetRight;
    public float lateralOffsetRightAcc;
    public float probs;
    public BigInteger tickTime;

    public LaneFusionResultExternal() {
        this.tickTime = new BigInteger("0");
        this.indices = (byte) 0;
        this.probs = 0.0f;
        this.lateralOffsetLeft = 0.0f;
        this.lateralOffsetLeftAcc = 0.0f;
        this.lateralOffsetRight = 0.0f;
        this.lateralOffsetRightAcc = 0.0f;
    }

    public LaneFusionResultExternal(BigInteger bigInteger, byte b, float f, float f2, float f3, float f4, float f5) {
        this.tickTime = bigInteger;
        this.indices = b;
        this.probs = f;
        this.lateralOffsetLeft = f2;
        this.lateralOffsetLeftAcc = f3;
        this.lateralOffsetRight = f4;
        this.lateralOffsetRightAcc = f5;
    }
}

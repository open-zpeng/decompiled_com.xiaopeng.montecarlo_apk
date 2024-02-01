package com.autonavi.gbl.pos.model;

import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LaneReference implements Serializable {
    public BigInteger laneId;
    public short laneNum;
    public float offsetLat;
    public float offsetLon;

    public LaneReference() {
        this.laneId = new BigInteger("0");
        this.laneNum = (short) 0;
        this.offsetLon = 0.0f;
        this.offsetLat = 0.0f;
    }

    public LaneReference(BigInteger bigInteger, short s, float f, float f2) {
        this.laneId = bigInteger;
        this.laneNum = s;
        this.offsetLon = f;
        this.offsetLat = f2;
    }
}

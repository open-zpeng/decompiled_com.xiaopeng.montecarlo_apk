package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LaneNumType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocLaneNum implements Serializable {
    public short laneNum;
    public double laneNumQuality;
    @LaneNumType.LaneNumType1
    public int laneNumType;
    public BigInteger laneTypeCombine;

    public LocLaneNum() {
        this.laneNumType = 0;
        this.laneTypeCombine = new BigInteger("0");
        this.laneNum = (short) 0;
        this.laneNumQuality = 0.0d;
    }

    public LocLaneNum(@LaneNumType.LaneNumType1 int i, BigInteger bigInteger, short s, double d) {
        this.laneNumType = i;
        this.laneTypeCombine = bigInteger;
        this.laneNum = s;
        this.laneNumQuality = d;
    }
}

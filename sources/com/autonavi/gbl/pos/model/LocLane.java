package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LaneMarkColor;
import com.autonavi.gbl.pos.model.LaneType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocLane implements Serializable {
    public double c0;
    public double c1;
    public double c2;
    public double c3;
    @LaneMarkColor.LaneMarkColor1
    public int color;
    public double qualityGeometry;
    public double qualityType;
    @LaneType.LaneType1
    public int type;
    public double viewRangeEnd;
    public double viewRangeStart;
    public double width;

    public LocLane() {
        this.type = 0;
        this.c0 = 0.0d;
        this.c1 = 0.0d;
        this.c2 = 0.0d;
        this.c3 = 0.0d;
        this.width = 0.0d;
        this.qualityGeometry = 0.0d;
        this.qualityType = 0.0d;
        this.viewRangeStart = 0.0d;
        this.viewRangeEnd = 0.0d;
        this.color = 0;
    }

    public LocLane(@LaneType.LaneType1 int i, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, @LaneMarkColor.LaneMarkColor1 int i2) {
        this.type = i;
        this.c0 = d;
        this.c1 = d2;
        this.c2 = d3;
        this.c3 = d4;
        this.width = d5;
        this.qualityGeometry = d6;
        this.qualityType = d7;
        this.viewRangeStart = d8;
        this.viewRangeEnd = d9;
        this.color = i2;
    }
}

package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LaneMarkColor;
import com.autonavi.gbl.pos.model.LaneType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocLane implements Serializable {
    @LaneMarkColor.LaneMarkColor1
    public int color;
    public LineGeometry geometry;
    public double qualityColor;
    public double qualityType;
    @LaneType.LaneType1
    public int type;

    public LocLane() {
        this.geometry = new LineGeometry();
        this.type = 0;
        this.qualityType = 0.0d;
        this.color = 0;
        this.qualityColor = 0.0d;
    }

    public LocLane(LineGeometry lineGeometry, @LaneType.LaneType1 int i, double d, @LaneMarkColor.LaneMarkColor1 int i2, double d2) {
        this.geometry = lineGeometry;
        this.type = i;
        this.qualityType = d;
        this.color = i2;
        this.qualityColor = d2;
    }
}

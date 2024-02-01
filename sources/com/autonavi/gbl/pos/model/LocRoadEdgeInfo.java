package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.RoadEdgeType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocRoadEdgeInfo implements Serializable {
    public LineGeometry geometry;
    @RoadEdgeType.RoadEdgeType1
    public int roadEdgeType;

    public LocRoadEdgeInfo() {
        this.roadEdgeType = 0;
        this.geometry = new LineGeometry();
    }

    public LocRoadEdgeInfo(@RoadEdgeType.RoadEdgeType1 int i, LineGeometry lineGeometry) {
        this.roadEdgeType = i;
        this.geometry = lineGeometry;
    }
}

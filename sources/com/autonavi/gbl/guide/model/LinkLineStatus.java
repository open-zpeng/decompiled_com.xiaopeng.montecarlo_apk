package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LinkLineStatus implements Serializable {
    public ArrayList<Coord2DDouble> shapePoints;
    @TrafficStatus.TrafficStatus1
    public int status;

    public LinkLineStatus() {
        this.shapePoints = new ArrayList<>();
        this.status = 0;
    }

    public LinkLineStatus(ArrayList<Coord2DDouble> arrayList, @TrafficStatus.TrafficStatus1 int i) {
        this.shapePoints = arrayList;
        this.status = i;
    }
}

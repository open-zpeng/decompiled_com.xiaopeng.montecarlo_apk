package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.FacilityType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviRoadFacility implements Serializable {
    public Coord2DDouble coord2D;
    public int distance;
    @FacilityType.FacilityType1
    public int type;

    public NaviRoadFacility() {
        this.coord2D = new Coord2DDouble();
        this.type = 0;
        this.distance = 0;
    }

    public NaviRoadFacility(Coord2DDouble coord2DDouble, @FacilityType.FacilityType1 int i, int i2) {
        this.coord2D = coord2DDouble;
        this.type = i;
        this.distance = i2;
    }
}

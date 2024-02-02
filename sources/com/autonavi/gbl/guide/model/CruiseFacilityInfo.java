package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.guide.model.CruiseFacilityType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CruiseFacilityInfo implements Serializable {
    public int distance;
    public int limitSpeed;
    public Coord2DDouble pos;
    @CruiseFacilityType.CruiseFacilityType1
    public int type;

    public CruiseFacilityInfo() {
        this.pos = new Coord2DDouble();
        this.type = 4;
        this.distance = 0;
        this.limitSpeed = 0;
    }

    public CruiseFacilityInfo(Coord2DDouble coord2DDouble, @CruiseFacilityType.CruiseFacilityType1 int i, int i2, int i3) {
        this.pos = coord2DDouble;
        this.type = i;
        this.distance = i2;
        this.limitSpeed = i3;
    }
}

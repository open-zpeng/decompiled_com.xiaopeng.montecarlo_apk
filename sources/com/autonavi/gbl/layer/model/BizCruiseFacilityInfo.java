package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.guide.model.CruiseFacilityType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class BizCruiseFacilityInfo extends BizBusinessInfo implements Serializable {
    @CruiseFacilityType.CruiseFacilityType1
    public int type = 4;
    public Coord3DDouble position = new Coord3DDouble();
    public int distance = 0;
    public int speed = 0;
}

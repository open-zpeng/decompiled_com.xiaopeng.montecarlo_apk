package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.RoadClass;
import java.io.Serializable;
/* loaded from: classes.dex */
public class BizGuideMixForkInfo extends BizBusinessInfo implements Serializable {
    public Coord3DDouble position = new Coord3DDouble();
    public int distance = 0;
    @RoadClass.RoadClass1
    public int roadClass = -1;
    public int segmentIndex = 0;
}

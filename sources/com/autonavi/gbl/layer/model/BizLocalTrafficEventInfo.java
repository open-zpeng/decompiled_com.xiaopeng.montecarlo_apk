package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.layer.model.LocalTrafficEventType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BizLocalTrafficEventInfo extends BizBusinessInfo implements Serializable {
    @LocalTrafficEventType.LocalTrafficEventType1
    public int eventType = 0;
    @RoadClass.RoadClass1
    public int roadClass = -1;
    public String eventID = "";
    public Coord3DDouble point = new Coord3DDouble();
    public ArrayList<Coord3DDouble> linePoints = new ArrayList<>();
}

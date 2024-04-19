package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.JamSegment;
import com.autonavi.gbl.common.path.model.TrafficIncident;
import java.io.Serializable;
/* loaded from: classes.dex */
public class RouteTrafficEventTipsPoint extends BizBusinessInfo implements Serializable {
    public Coord2DDouble mP20Point = new Coord2DDouble();
    public TrafficIncident mTrafficIncident = new TrafficIncident();
    public JamSegment mJamSegment = new JamSegment();
}

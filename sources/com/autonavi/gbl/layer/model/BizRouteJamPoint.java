package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.AvoidTrafficJamInfo;
import java.io.Serializable;
/* loaded from: classes.dex */
public class BizRouteJamPoint extends BizBusinessInfo implements Serializable {
    public Coord2DDouble point = new Coord2DDouble();
    public AvoidTrafficJamInfo avoidJamInfo = new AvoidTrafficJamInfo();
}

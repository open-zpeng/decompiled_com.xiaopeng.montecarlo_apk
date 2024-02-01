package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.model.CustomPriorityMode;
import com.autonavi.gbl.map.layer.model.SectorAngles;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizCustomCircleInfo extends BizBusinessInfo implements Serializable {
    @CustomPriorityMode.CustomPriorityMode1
    public int priorityMode = 1;
    public int type = 0;
    public String value = "";
    public double radius = 0.0d;
    public Coord3DDouble center = new Coord3DDouble();
    public SectorAngles sectorAngles = new SectorAngles();
}

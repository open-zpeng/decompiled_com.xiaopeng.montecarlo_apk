package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.model.CustomPriorityMode;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BizCustomPolygonInfo extends BizBusinessInfo implements Serializable {
    @CustomPriorityMode.CustomPriorityMode1
    public int priorityMode = 1;
    public int type = 0;
    public String value = "";
    public ArrayList<Coord3DDouble> vecPoints = new ArrayList<>();
}

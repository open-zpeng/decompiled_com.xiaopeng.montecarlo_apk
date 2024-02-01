package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.layer.model.CustomPriorityMode;
import com.autonavi.gbl.map.layer.model.PolygonGradientPointInfo;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BizCustomGradientPolygonInfo extends BizBusinessInfo implements Serializable {
    @CustomPriorityMode.CustomPriorityMode1
    public int priorityMode = 1;
    public int type = 0;
    public String value = "";
    public ArrayList<PolygonGradientPointInfo> vecPoints = new ArrayList<>();
}

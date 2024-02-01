package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BizRouteRestrictInfo extends BizBusinessInfo implements Serializable {
    public boolean isDrawPolygonRim = false;
    public ArrayList<Coord3DDouble> polygonPoints = new ArrayList<>();
    public ArrayList<ArrayList<Coord3DDouble>> lineInfos = new ArrayList<>();
}

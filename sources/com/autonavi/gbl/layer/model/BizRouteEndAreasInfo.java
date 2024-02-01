package com.autonavi.gbl.layer.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BizRouteEndAreasInfo implements Serializable {
    public ArrayList<BizPolygonBusinessInfo> vecAreaPolygonInfo;
    public ArrayList<RouteEndAreaPointInfo> vecChildPointInfo;
    public ArrayList<RouteEndAreaPointInfo> vecParentPointInfo;

    public BizRouteEndAreasInfo() {
        this.vecAreaPolygonInfo = new ArrayList<>();
        this.vecParentPointInfo = new ArrayList<>();
        this.vecChildPointInfo = new ArrayList<>();
    }

    public BizRouteEndAreasInfo(ArrayList<BizPolygonBusinessInfo> arrayList, ArrayList<RouteEndAreaPointInfo> arrayList2, ArrayList<RouteEndAreaPointInfo> arrayList3) {
        this.vecAreaPolygonInfo = arrayList;
        this.vecParentPointInfo = arrayList2;
        this.vecChildPointInfo = arrayList3;
    }
}

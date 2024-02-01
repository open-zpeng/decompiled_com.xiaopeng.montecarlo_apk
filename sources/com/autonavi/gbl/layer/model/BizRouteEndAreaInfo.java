package com.autonavi.gbl.layer.model;

import java.io.Serializable;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes2.dex */
public class BizRouteEndAreaInfo extends BizPolygonBusinessInfo implements Serializable {
    public ArrayList<RouteEndAreaPointInfo> mVecParentPointInfo = new ArrayList<>();
    public ArrayList<RouteEndAreaPointInfo> mVecChildPointInfo = new ArrayList<>();
}

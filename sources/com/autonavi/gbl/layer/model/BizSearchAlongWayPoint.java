package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.layer.model.AlongWayLabelType;
import com.autonavi.gbl.layer.model.SearchAlongwayType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizSearchAlongWayPoint extends BizPointBusinessInfo implements Serializable {
    @SearchAlongwayType.SearchAlongwayType1
    public int searchType = 9;
    @AlongWayLabelType.AlongWayLabelType1
    public int labelType = 0;
    public int typeCode = 0;
    public int travelTime = -1;
    public String name = "";
    public SearchAlongWayExtraData mExtraData = new SearchAlongWayExtraData();
}

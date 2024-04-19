package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.RoadClass;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CruiseInfo implements Serializable {
    @RoadClass.RoadClass1
    public int roadClass;
    public String roadName;

    public CruiseInfo() {
        this.roadName = "";
        this.roadClass = -1;
    }

    public CruiseInfo(String str, @RoadClass.RoadClass1 int i) {
        this.roadName = str;
        this.roadClass = i;
    }
}

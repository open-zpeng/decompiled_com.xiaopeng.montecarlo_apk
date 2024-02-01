package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.path.model.AvoidJamArea;
import com.autonavi.gbl.common.path.model.AvoidRestrictArea;
import com.autonavi.gbl.common.path.model.ForbiddenInfo;
import com.autonavi.gbl.common.path.model.RoadClosedArea;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class GuideETAEvent implements Serializable {
    public AvoidJamArea avoidJamArea;
    public AvoidRestrictArea avoidRestrictArea;
    public ForbiddenInfo forbiddenInfo;
    public RoadClosedArea roadClosedArea;
    public int type;

    public GuideETAEvent() {
        this.type = 0;
        this.avoidJamArea = new AvoidJamArea();
        this.avoidRestrictArea = new AvoidRestrictArea();
        this.forbiddenInfo = new ForbiddenInfo();
        this.roadClosedArea = new RoadClosedArea();
    }

    public GuideETAEvent(int i, AvoidJamArea avoidJamArea, AvoidRestrictArea avoidRestrictArea, ForbiddenInfo forbiddenInfo, RoadClosedArea roadClosedArea) {
        this.type = i;
        this.avoidJamArea = avoidJamArea;
        this.avoidRestrictArea = avoidRestrictArea;
        this.forbiddenInfo = forbiddenInfo;
        this.roadClosedArea = roadClosedArea;
    }
}

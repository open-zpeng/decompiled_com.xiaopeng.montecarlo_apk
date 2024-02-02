package com.autonavi.gbl.common.path.model;
/* loaded from: classes.dex */
public class RouteLimitInfo {
    public AvoidJamArea avoidJamArea;
    public AvoidRestrictArea avoidRestrictArea;
    public ForbiddenInfo forbiddenInfo;
    public RoadClosedArea roadClosedArea;

    public RouteLimitInfo() {
        this.forbiddenInfo = new ForbiddenInfo();
        this.roadClosedArea = new RoadClosedArea();
        this.avoidJamArea = new AvoidJamArea();
        this.avoidRestrictArea = new AvoidRestrictArea();
    }

    public RouteLimitInfo(ForbiddenInfo forbiddenInfo, RoadClosedArea roadClosedArea, AvoidJamArea avoidJamArea, AvoidRestrictArea avoidRestrictArea) {
        this.forbiddenInfo = forbiddenInfo;
        this.roadClosedArea = roadClosedArea;
        this.avoidJamArea = avoidJamArea;
        this.avoidRestrictArea = avoidRestrictArea;
    }
}

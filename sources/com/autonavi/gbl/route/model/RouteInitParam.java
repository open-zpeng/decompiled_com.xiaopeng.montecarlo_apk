package com.autonavi.gbl.route.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RouteInitParam implements Serializable {
    public RouteCollisionParam collisionParam;
    public RerouteParam rerouteParam;

    public RouteInitParam() {
        this.rerouteParam = new RerouteParam();
        this.collisionParam = new RouteCollisionParam();
    }

    public RouteInitParam(RerouteParam rerouteParam, RouteCollisionParam routeCollisionParam) {
        this.rerouteParam = rerouteParam;
        this.collisionParam = routeCollisionParam;
    }
}

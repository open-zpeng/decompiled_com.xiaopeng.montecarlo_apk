package com.autonavi.gbl.route.model;

import com.autonavi.gbl.route.model.RouteCollisionSolution;
import com.autonavi.gbl.route.model.RouteSerialParallelState;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class RouteCollisionParam implements Serializable {
    public String hmiRouteRequestPriorityFile;
    @RouteCollisionSolution.RouteCollisionSolution1
    public int solution;
    @RouteSerialParallelState.RouteSerialParallelState1
    public int state;

    public RouteCollisionParam() {
        this.state = 0;
        this.solution = 0;
        this.hmiRouteRequestPriorityFile = "";
    }

    public RouteCollisionParam(@RouteSerialParallelState.RouteSerialParallelState1 int i, @RouteCollisionSolution.RouteCollisionSolution1 int i2, String str) {
        this.state = i;
        this.solution = i2;
        this.hmiRouteRequestPriorityFile = str;
    }
}

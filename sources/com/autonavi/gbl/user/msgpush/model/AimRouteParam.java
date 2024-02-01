package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AimRouteParam implements Serializable {
    public MobileRoutePointType pointType;
    public MobileRouteParam routeParam;

    public AimRouteParam() {
        this.routeParam = new MobileRouteParam();
        this.pointType = new MobileRoutePointType();
    }

    public AimRouteParam(MobileRouteParam mobileRouteParam, MobileRoutePointType mobileRoutePointType) {
        this.routeParam = mobileRouteParam;
        this.pointType = mobileRoutePointType;
    }
}

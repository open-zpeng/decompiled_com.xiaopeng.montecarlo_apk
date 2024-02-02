package com.autonavi.gbl.user.msgpush.model;
/* loaded from: classes2.dex */
public class AimRouteParam {
    public MobileRoutePointType pointType;
    public MobileRouteParam routeParam;

    public AimRouteParam() {
        this.routeParam = null;
        this.pointType = null;
    }

    public AimRouteParam(MobileRouteParam mobileRouteParam, MobileRoutePointType mobileRoutePointType) {
        this.routeParam = mobileRouteParam;
        this.pointType = mobileRoutePointType;
    }
}

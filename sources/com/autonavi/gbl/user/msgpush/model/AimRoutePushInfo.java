package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AimRoutePushInfo implements Serializable {
    public int isOnline;
    public String naviId;
    public RoutepathrestorationPathInfo path;
    public MobileRouteParam routeParam;
    public int sendMode;

    public AimRoutePushInfo() {
        this.sendMode = 0;
        this.isOnline = 0;
        this.naviId = "";
        this.routeParam = new MobileRouteParam();
        this.path = new RoutepathrestorationPathInfo();
    }

    public AimRoutePushInfo(int i, int i2, String str, MobileRouteParam mobileRouteParam, RoutepathrestorationPathInfo routepathrestorationPathInfo) {
        this.sendMode = i;
        this.isOnline = i2;
        this.naviId = str;
        this.routeParam = mobileRouteParam;
        this.path = routepathrestorationPathInfo;
    }
}

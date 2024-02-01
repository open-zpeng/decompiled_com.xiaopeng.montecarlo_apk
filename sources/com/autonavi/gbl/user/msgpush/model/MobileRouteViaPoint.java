package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MobileRouteViaPoint implements Serializable {
    public String lat;
    public String lon;
    public String name;
    public String poiId;
    public int type;
    public String typeCode;

    public MobileRouteViaPoint() {
        this.type = 0;
        this.name = "";
        this.lon = "";
        this.lat = "";
        this.poiId = "";
        this.typeCode = "";
    }

    public MobileRouteViaPoint(int i, String str, String str2, String str3, String str4, String str5) {
        this.type = i;
        this.name = str;
        this.lon = str2;
        this.lat = str3;
        this.poiId = str4;
        this.typeCode = str5;
    }
}

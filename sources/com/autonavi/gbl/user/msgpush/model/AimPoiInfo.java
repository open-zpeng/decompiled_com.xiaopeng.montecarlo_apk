package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AimPoiInfo implements Serializable {
    public String address;
    public int childType;
    public int endPoiExtension;
    public String floorNo;
    public int lat;
    public int lon;
    public String name;
    public int navLat;
    public int navLon;
    public String parent;
    public String poiId;
    public String poiType;
    public String towardsAngle;

    public AimPoiInfo() {
        this.address = "";
        this.name = "";
        this.poiId = "";
        this.poiType = "";
        this.lon = 0;
        this.lat = 0;
        this.navLon = 0;
        this.navLat = 0;
        this.parent = "";
        this.childType = 0;
        this.towardsAngle = "";
        this.floorNo = "";
        this.endPoiExtension = 0;
    }

    public AimPoiInfo(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, String str5, int i5, String str6, String str7, int i6) {
        this.address = str;
        this.name = str2;
        this.poiId = str3;
        this.poiType = str4;
        this.lon = i;
        this.lat = i2;
        this.navLon = i3;
        this.navLat = i4;
        this.parent = str5;
        this.childType = i5;
        this.towardsAngle = str6;
        this.floorNo = str7;
        this.endPoiExtension = i6;
    }
}

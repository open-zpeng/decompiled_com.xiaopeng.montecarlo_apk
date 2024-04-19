package com.autonavi.gbl.user.usertrack.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class RecvRoutePoi implements Serializable {
    public String address;
    public int childType;
    public int cityCode;
    public String cityName;
    public int endPoiExtension;
    public String floorNo;
    public String name;
    public Coord2DDouble navLoc;
    public String parent;
    public String poiId;
    public Coord2DDouble poiLoc;
    public String towardsAngle;
    public String typeCode;

    public RecvRoutePoi() {
        this.poiId = "";
        this.typeCode = "";
        this.name = "";
        this.address = "";
        this.poiLoc = new Coord2DDouble();
        this.navLoc = new Coord2DDouble();
        this.cityCode = 0;
        this.cityName = "";
        this.parent = "";
        this.childType = 0;
        this.towardsAngle = "";
        this.floorNo = "";
        this.endPoiExtension = 0;
    }

    public RecvRoutePoi(String str, String str2, String str3, String str4, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, int i, String str5, String str6, int i2, String str7, String str8, int i3) {
        this.poiId = str;
        this.typeCode = str2;
        this.name = str3;
        this.address = str4;
        this.poiLoc = coord2DDouble;
        this.navLoc = coord2DDouble2;
        this.cityCode = i;
        this.cityName = str5;
        this.parent = str6;
        this.childType = i2;
        this.towardsAngle = str7;
        this.floorNo = str8;
        this.endPoiExtension = i3;
    }
}

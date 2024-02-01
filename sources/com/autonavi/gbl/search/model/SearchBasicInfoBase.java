package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchBasicInfoBase implements Serializable {
    public int adcode;
    public String address;
    public int averageCost;
    public int cityCode;
    public String cityName;
    public String distance;
    public Coord2DDouble location;
    public String name;
    public String openTime;
    public String poiId;
    public String rating;
    public int reviewTotal;
    public String tel;
    public String typeCode;

    public SearchBasicInfoBase() {
        this.reviewTotal = 0;
        this.cityCode = 0;
        this.adcode = 0;
        this.averageCost = 0;
        this.location = new Coord2DDouble();
        this.name = "";
        this.cityName = "";
        this.poiId = "";
        this.address = "";
        this.distance = "";
        this.typeCode = "";
        this.rating = "";
        this.openTime = "";
        this.tel = "";
    }

    public SearchBasicInfoBase(int i, int i2, int i3, int i4, Coord2DDouble coord2DDouble, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.reviewTotal = i;
        this.cityCode = i2;
        this.adcode = i3;
        this.averageCost = i4;
        this.location = coord2DDouble;
        this.name = str;
        this.cityName = str2;
        this.poiId = str3;
        this.address = str4;
        this.distance = str5;
        this.typeCode = str6;
        this.rating = str7;
        this.openTime = str8;
        this.tel = str9;
    }
}

package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class NearestPoi implements Serializable {
    public String address;
    public int distance;
    public int nAdCode;
    public int nCityAdCode;
    public String name;
    public Coord2DDouble naviPoint;
    public String poiid;
    public Coord2DDouble point;
    public String tel;
    public String type;
    public String typecode;
    public String weight;

    public NearestPoi() {
        this.distance = 0;
        this.tel = "";
        this.name = "";
        this.weight = "";
        this.point = new Coord2DDouble();
        this.naviPoint = new Coord2DDouble();
        this.typecode = "";
        this.address = "";
        this.type = "";
        this.poiid = "";
        this.nCityAdCode = 0;
        this.nAdCode = 0;
    }

    public NearestPoi(int i, String str, String str2, String str3, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, String str4, String str5, String str6, String str7, int i2, int i3) {
        this.distance = i;
        this.tel = str;
        this.name = str2;
        this.weight = str3;
        this.point = coord2DDouble;
        this.naviPoint = coord2DDouble2;
        this.typecode = str4;
        this.address = str5;
        this.type = str6;
        this.poiid = str7;
        this.nCityAdCode = i2;
        this.nAdCode = i3;
    }
}

package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchCmallPoiInfo implements Serializable {
    public String address;
    public String averageCost;
    public double distance;
    public String name;
    public String picUrl;
    public String poiId;
    public Coord2DDouble poiLoc;
    public String rate;

    public SearchCmallPoiInfo() {
        this.poiId = "";
        this.name = "";
        this.picUrl = "";
        this.rate = "";
        this.averageCost = "";
        this.address = "";
        this.poiLoc = new Coord2DDouble();
        this.distance = 0.0d;
    }

    public SearchCmallPoiInfo(String str, String str2, String str3, String str4, String str5, String str6, Coord2DDouble coord2DDouble, double d) {
        this.poiId = str;
        this.name = str2;
        this.picUrl = str3;
        this.rate = str4;
        this.averageCost = str5;
        this.address = str6;
        this.poiLoc = coord2DDouble;
        this.distance = d;
    }
}

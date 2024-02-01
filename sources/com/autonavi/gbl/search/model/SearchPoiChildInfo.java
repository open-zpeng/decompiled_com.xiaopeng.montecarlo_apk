package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.search.model.SearchPoiNavigationLabel;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiChildInfo implements Serializable {
    public String address;
    public int childType;
    public String label;
    public Coord2DDouble location;
    public String name;
    @SearchPoiNavigationLabel.SearchPoiNavigationLabel1
    public int navigation;
    public String poiId;
    public Coord2DDouble pointEnter;
    public double ratio;
    public String shortName;

    public SearchPoiChildInfo() {
        this.childType = 0;
        this.navigation = 0;
        this.ratio = 0.0d;
        this.location = new Coord2DDouble();
        this.pointEnter = new Coord2DDouble();
        this.poiId = "";
        this.name = "";
        this.shortName = "";
        this.address = "";
        this.label = "";
    }

    public SearchPoiChildInfo(int i, @SearchPoiNavigationLabel.SearchPoiNavigationLabel1 int i2, double d, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, String str, String str2, String str3, String str4, String str5) {
        this.childType = i;
        this.navigation = i2;
        this.ratio = d;
        this.location = coord2DDouble;
        this.pointEnter = coord2DDouble2;
        this.poiId = str;
        this.name = str2;
        this.shortName = str3;
        this.address = str4;
        this.label = str5;
    }
}

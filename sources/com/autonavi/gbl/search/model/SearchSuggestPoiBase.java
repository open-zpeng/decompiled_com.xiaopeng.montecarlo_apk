package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchSuggestPoiBase implements Serializable {
    public int adcode;
    public String address;
    public String category;
    public int datatype;
    public int datatype_spec;
    public String name;
    public Coord2DDouble naviPoint;
    public String poiid;
    public Coord2DDouble point;
    public String short_name;

    public SearchSuggestPoiBase() {
        this.adcode = -1;
        this.datatype_spec = 0;
        this.datatype = 0;
        this.poiid = "";
        this.name = "";
        this.short_name = "";
        this.address = "";
        this.category = "";
        this.point = new Coord2DDouble();
        this.naviPoint = new Coord2DDouble();
    }

    public SearchSuggestPoiBase(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2) {
        this.adcode = i;
        this.datatype_spec = i2;
        this.datatype = i3;
        this.poiid = str;
        this.name = str2;
        this.short_name = str3;
        this.address = str4;
        this.category = str5;
        this.point = coord2DDouble;
        this.naviPoint = coord2DDouble2;
    }
}

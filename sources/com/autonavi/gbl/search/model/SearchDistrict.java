package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchDistrict implements Serializable {
    public int adcode;
    public String address;
    public String ename;
    public String name;
    public Coord2DDouble poi_loc;
    public ArrayList<SearchPolygonBound> polygonBounds;

    public SearchDistrict() {
        this.adcode = 0;
        this.name = "";
        this.ename = "";
        this.address = "";
        this.poi_loc = new Coord2DDouble();
        this.polygonBounds = new ArrayList<>();
    }

    public SearchDistrict(int i, String str, String str2, String str3, Coord2DDouble coord2DDouble, ArrayList<SearchPolygonBound> arrayList) {
        this.adcode = i;
        this.name = str;
        this.ename = str2;
        this.address = str3;
        this.poi_loc = coord2DDouble;
        this.polygonBounds = arrayList;
    }
}

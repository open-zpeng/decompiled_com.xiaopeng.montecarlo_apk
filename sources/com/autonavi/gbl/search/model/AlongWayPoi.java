package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlongWayPoi implements Serializable {
    public String address;
    public SearchRoadId bindRoadId;
    public String brand_desc;
    public int dist_to_via;
    public String distance;
    public String eaddress;
    public String ename;
    public int eta_to_via;
    public String geometry;
    public String id;
    public int label_type;
    public int left_right;
    public int nAdCode;
    public int nCityAdCode;
    public String name;
    public Coord2DDouble point;
    public Coord2DDouble pointEnter;
    public Coord2DDouble pointExit;
    public ArrayList<PricePoiInfo> pricelist;
    public String status;
    public int toll;
    public String travel_time;
    public String typecode;
    public int vehiclechargeleft;
    public int via_level;

    public AlongWayPoi() {
        this.name = "";
        this.ename = "";
        this.point = new Coord2DDouble();
        this.pointEnter = new Coord2DDouble();
        this.pointExit = new Coord2DDouble();
        this.eaddress = "";
        this.address = "";
        this.id = "";
        this.typecode = "";
        this.left_right = 0;
        this.status = "";
        this.travel_time = "";
        this.distance = "";
        this.label_type = 0;
        this.geometry = "";
        this.nCityAdCode = 0;
        this.nAdCode = 0;
        this.pricelist = new ArrayList<>();
        this.dist_to_via = 0;
        this.eta_to_via = 0;
        this.vehiclechargeleft = 0;
        this.toll = 0;
        this.via_level = 0;
        this.brand_desc = "";
        this.bindRoadId = new SearchRoadId();
    }

    public AlongWayPoi(String str, String str2, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, Coord2DDouble coord2DDouble3, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, int i2, String str10, int i3, int i4, ArrayList<PricePoiInfo> arrayList, int i5, int i6, int i7, int i8, int i9, String str11, SearchRoadId searchRoadId) {
        this.name = str;
        this.ename = str2;
        this.point = coord2DDouble;
        this.pointEnter = coord2DDouble2;
        this.pointExit = coord2DDouble3;
        this.eaddress = str3;
        this.address = str4;
        this.id = str5;
        this.typecode = str6;
        this.left_right = i;
        this.status = str7;
        this.travel_time = str8;
        this.distance = str9;
        this.label_type = i2;
        this.geometry = str10;
        this.nCityAdCode = i3;
        this.nAdCode = i4;
        this.pricelist = arrayList;
        this.dist_to_via = i5;
        this.eta_to_via = i6;
        this.vehiclechargeleft = i7;
        this.toll = i8;
        this.via_level = i9;
        this.brand_desc = str11;
        this.bindRoadId = searchRoadId;
    }
}

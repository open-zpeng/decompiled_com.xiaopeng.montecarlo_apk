package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.search.model.SearchDeepInfoBusinessType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DeepinfoPoi implements Serializable {
    public int adcode;
    public String address;
    public DeepAirport airportInfo;
    public String brand;
    public String business;
    public String businessCircle;
    public ArrayList<DeepCharging> chargeData;
    public ArrayList<SearchChargeProvider> chargeProviders;
    public int city_adcode;
    @SearchDeepInfoBusinessType.SearchDeepInfoBusinessType1
    public int eBusinessType;
    public ArrayList<DeepinfoPoiGasinfo> gasinfoList;
    public String name;
    public String opentime;
    public DeepinfoPoiParkinfo parkinfo;
    public Coord2DDouble poi_loc;
    public Coord2DDouble poi_navi;
    public String poiid;
    public String tag;
    public String tagPoiUse;
    public String tel;
    public DeepTrainStation trainStation;
    public String typecode;

    public DeepinfoPoi() {
        this.poi_loc = new Coord2DDouble();
        this.poi_navi = new Coord2DDouble();
        this.city_adcode = 0;
        this.adcode = 0;
        this.poiid = "";
        this.name = "";
        this.typecode = "";
        this.address = "";
        this.tel = "";
        this.tag = "";
        this.tagPoiUse = "";
        this.businessCircle = "";
        this.business = "";
        this.brand = "";
        this.opentime = "";
        this.eBusinessType = 0;
        this.parkinfo = new DeepinfoPoiParkinfo();
        this.chargeData = new ArrayList<>();
        this.chargeProviders = new ArrayList<>();
        this.gasinfoList = new ArrayList<>();
        this.airportInfo = new DeepAirport();
        this.trainStation = new DeepTrainStation();
    }

    public DeepinfoPoi(Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, @SearchDeepInfoBusinessType.SearchDeepInfoBusinessType1 int i3, DeepinfoPoiParkinfo deepinfoPoiParkinfo, ArrayList<DeepCharging> arrayList, ArrayList<SearchChargeProvider> arrayList2, ArrayList<DeepinfoPoiGasinfo> arrayList3, DeepAirport deepAirport, DeepTrainStation deepTrainStation) {
        this.poi_loc = coord2DDouble;
        this.poi_navi = coord2DDouble2;
        this.city_adcode = i;
        this.adcode = i2;
        this.poiid = str;
        this.name = str2;
        this.typecode = str3;
        this.address = str4;
        this.tel = str5;
        this.tag = str6;
        this.tagPoiUse = str7;
        this.businessCircle = str8;
        this.business = str9;
        this.brand = str10;
        this.opentime = str11;
        this.eBusinessType = i3;
        this.parkinfo = deepinfoPoiParkinfo;
        this.chargeData = arrayList;
        this.chargeProviders = arrayList2;
        this.gasinfoList = arrayList3;
        this.airportInfo = deepAirport;
        this.trainStation = deepTrainStation;
    }
}

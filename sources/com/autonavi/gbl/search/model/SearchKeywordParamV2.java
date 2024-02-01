package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchKeywordParamV2 implements Serializable {
    public String busOrCar;
    public String category;
    public String center;
    public String city;
    public String clusterState;
    public String cmsPoi;
    public KeywordSearchCustomParam customParam;
    public String dataType;
    public String geoObj;
    public KeywordSearchHotelParam hotelParam;
    public String keywords;
    public KeywordSearchOfflineParam offlineParam;
    public String onlyPoi;
    public SearchPageParam pageParam;
    public Coord2DDouble poiLoc;
    public String queryType;
    public String range;
    public SearchRetainParam retainParam;
    public int scenario;
    public int sortRule;
    public int specialSearch;
    public KeywordSearchSwitchParam switchParam;
    public String userCity;
    public Coord2DDouble userLoc;
    public String utdSceneId;
    public String version;

    public SearchKeywordParamV2() {
        this.queryType = "";
        this.specialSearch = 0;
        this.poiLoc = new Coord2DDouble();
        this.range = "";
        this.dataType = "poi";
        this.city = "";
        this.keywords = "";
        this.category = "";
        this.sortRule = 0;
        this.geoObj = "";
        this.center = "";
        this.userLoc = new Coord2DDouble();
        this.userCity = "";
        this.cmsPoi = "1";
        this.onlyPoi = "poi";
        this.busOrCar = "";
        this.utdSceneId = "";
        this.clusterState = "5";
        this.scenario = 1;
        this.version = "2.17";
        this.pageParam = new SearchPageParam();
        this.offlineParam = new KeywordSearchOfflineParam();
        this.switchParam = new KeywordSearchSwitchParam();
        this.hotelParam = new KeywordSearchHotelParam();
        this.customParam = new KeywordSearchCustomParam();
        this.retainParam = new SearchRetainParam();
        Coord2DDouble coord2DDouble = this.poiLoc;
        coord2DDouble.lon = -999.0d;
        coord2DDouble.lat = -999.0d;
        Coord2DDouble coord2DDouble2 = this.userLoc;
        coord2DDouble2.lon = -999.0d;
        coord2DDouble2.lat = -999.0d;
    }

    public SearchKeywordParamV2(String str, int i, Coord2DDouble coord2DDouble, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8, Coord2DDouble coord2DDouble2, String str9, String str10, String str11, String str12, String str13, String str14, int i3, String str15, SearchPageParam searchPageParam, KeywordSearchOfflineParam keywordSearchOfflineParam, KeywordSearchSwitchParam keywordSearchSwitchParam, KeywordSearchHotelParam keywordSearchHotelParam, KeywordSearchCustomParam keywordSearchCustomParam, SearchRetainParam searchRetainParam) {
        this.queryType = str;
        this.specialSearch = i;
        this.poiLoc = coord2DDouble;
        this.range = str2;
        this.dataType = str3;
        this.city = str4;
        this.keywords = str5;
        this.category = str6;
        this.sortRule = i2;
        this.geoObj = str7;
        this.center = str8;
        this.userLoc = coord2DDouble2;
        this.userCity = str9;
        this.cmsPoi = str10;
        this.onlyPoi = str11;
        this.busOrCar = str12;
        this.utdSceneId = str13;
        this.clusterState = str14;
        this.scenario = i3;
        this.version = str15;
        this.pageParam = searchPageParam;
        this.offlineParam = keywordSearchOfflineParam;
        this.switchParam = keywordSearchSwitchParam;
        this.hotelParam = keywordSearchHotelParam;
        this.customParam = keywordSearchCustomParam;
        this.retainParam = searchRetainParam;
    }
}

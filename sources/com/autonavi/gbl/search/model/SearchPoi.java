package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class SearchPoi implements Serializable {
    public ChargingStationInfo chargingStationInfo;
    public ArrayList<SearchPoiBase> childPois;
    public ArrayList<SearchPoiBase> childStations;
    public int displayIconNameState;
    public Coord2DDouble displayPoint;
    public ArrayList<String> floorList;
    public ArrayList<SearchGasInfo> gasInfo;
    public String gintCostTime;
    public HashMap<Integer, SearchCommonTemplate> mTempDataMap;
    public String markerBGRes;
    public int needArriveTimeCost;
    public int parentId;
    public SearchParkInfo parkInfo;
    public SearchPoiBase poi;
    public SearchPoiExtBase poiExt;
    public ArrayList<Coord2DDouble> poiPolygonBounds;
    public ArrayList<ArrayList<Coord2DDouble>> poiRoadaoiBounds;
    public int referenceRltFlag;
    public ArrayList<Integer> rights;
    public int sugLen;
    public int sugPos;
    public String typeName;

    public SearchPoi() {
        this.poi = new SearchPoiBase();
        this.poiExt = new SearchPoiExtBase();
        this.needArriveTimeCost = 0;
        this.gintCostTime = "";
        this.childPois = new ArrayList<>();
        this.childStations = new ArrayList<>();
        this.markerBGRes = "";
        this.displayIconNameState = 0;
        this.displayPoint = new Coord2DDouble();
        this.referenceRltFlag = 0;
        this.parentId = 0;
        this.typeName = "";
        this.sugPos = 0;
        this.sugLen = 0;
        this.mTempDataMap = new HashMap<>();
        this.poiPolygonBounds = new ArrayList<>();
        this.poiRoadaoiBounds = new ArrayList<>();
        this.gasInfo = new ArrayList<>();
        this.rights = new ArrayList<>();
        this.parkInfo = new SearchParkInfo();
        this.chargingStationInfo = new ChargingStationInfo();
        this.floorList = new ArrayList<>();
    }

    public SearchPoi(SearchPoiBase searchPoiBase, SearchPoiExtBase searchPoiExtBase, int i, String str, ArrayList<SearchPoiBase> arrayList, ArrayList<SearchPoiBase> arrayList2, String str2, int i2, Coord2DDouble coord2DDouble, int i3, int i4, String str3, int i5, int i6, HashMap<Integer, SearchCommonTemplate> hashMap, ArrayList<Coord2DDouble> arrayList3, ArrayList<ArrayList<Coord2DDouble>> arrayList4, ArrayList<SearchGasInfo> arrayList5, ArrayList<Integer> arrayList6, SearchParkInfo searchParkInfo, ChargingStationInfo chargingStationInfo, ArrayList<String> arrayList7) {
        this.poi = searchPoiBase;
        this.poiExt = searchPoiExtBase;
        this.needArriveTimeCost = i;
        this.gintCostTime = str;
        this.childPois = arrayList;
        this.childStations = arrayList2;
        this.markerBGRes = str2;
        this.displayIconNameState = i2;
        this.displayPoint = coord2DDouble;
        this.referenceRltFlag = i3;
        this.parentId = i4;
        this.typeName = str3;
        this.sugPos = i5;
        this.sugLen = i6;
        this.mTempDataMap = hashMap;
        this.poiPolygonBounds = arrayList3;
        this.poiRoadaoiBounds = arrayList4;
        this.gasInfo = arrayList5;
        this.rights = arrayList6;
        this.parkInfo = searchParkInfo;
        this.chargingStationInfo = chargingStationInfo;
        this.floorList = arrayList7;
    }
}

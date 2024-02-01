package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiInfo implements Serializable {
    public SearchPoiBasicInfo basicInfo;
    public ArrayList<SearchPoiBuslineInfo> buslineInfo;
    public SearchPoiChargingStationInfo chargingStationInfo;
    public ArrayList<SearchPoiChildInfo> childInfoList;
    public SearchDynamicInfo dynamicInfo;
    public ArrayList<SearchPoiEventInfo> eventInfoList;
    public ArrayList<SearchPoiFloor> floorList;
    public SearchPoiGasInfo gasInfo;
    public SearchPoiHospitalTel hospitalTel;
    public SearchPoiHotelInfo hotelInfo;
    public SearchPoiIndoor indoorInfo;
    public String itemType;
    public SearchPoiOfflineInfo offlineInfo;
    public SearchPoiParkingInfo parkingInfo;
    public SearchPoiPhoto photoInfo;
    public ArrayList<SearchProductInfo> produceInfoList;
    public SearchPoiRankInfo rankInfo;

    public SearchPoiInfo() {
        this.itemType = "";
        this.basicInfo = new SearchPoiBasicInfo();
        this.rankInfo = new SearchPoiRankInfo();
        this.parkingInfo = new SearchPoiParkingInfo();
        this.gasInfo = new SearchPoiGasInfo();
        this.chargingStationInfo = new SearchPoiChargingStationInfo();
        this.hotelInfo = new SearchPoiHotelInfo();
        this.indoorInfo = new SearchPoiIndoor();
        this.childInfoList = new ArrayList<>();
        this.buslineInfo = new ArrayList<>();
        this.floorList = new ArrayList<>();
        this.hospitalTel = new SearchPoiHospitalTel();
        this.eventInfoList = new ArrayList<>();
        this.offlineInfo = new SearchPoiOfflineInfo();
        this.photoInfo = new SearchPoiPhoto();
        this.dynamicInfo = new SearchDynamicInfo();
        this.produceInfoList = new ArrayList<>();
    }

    public SearchPoiInfo(String str, SearchPoiBasicInfo searchPoiBasicInfo, SearchPoiRankInfo searchPoiRankInfo, SearchPoiParkingInfo searchPoiParkingInfo, SearchPoiGasInfo searchPoiGasInfo, SearchPoiChargingStationInfo searchPoiChargingStationInfo, SearchPoiHotelInfo searchPoiHotelInfo, SearchPoiIndoor searchPoiIndoor, ArrayList<SearchPoiChildInfo> arrayList, ArrayList<SearchPoiBuslineInfo> arrayList2, ArrayList<SearchPoiFloor> arrayList3, SearchPoiHospitalTel searchPoiHospitalTel, ArrayList<SearchPoiEventInfo> arrayList4, SearchPoiOfflineInfo searchPoiOfflineInfo, SearchPoiPhoto searchPoiPhoto, SearchDynamicInfo searchDynamicInfo, ArrayList<SearchProductInfo> arrayList5) {
        this.itemType = str;
        this.basicInfo = searchPoiBasicInfo;
        this.rankInfo = searchPoiRankInfo;
        this.parkingInfo = searchPoiParkingInfo;
        this.gasInfo = searchPoiGasInfo;
        this.chargingStationInfo = searchPoiChargingStationInfo;
        this.hotelInfo = searchPoiHotelInfo;
        this.indoorInfo = searchPoiIndoor;
        this.childInfoList = arrayList;
        this.buslineInfo = arrayList2;
        this.floorList = arrayList3;
        this.hospitalTel = searchPoiHospitalTel;
        this.eventInfoList = arrayList4;
        this.offlineInfo = searchPoiOfflineInfo;
        this.photoInfo = searchPoiPhoto;
        this.dynamicInfo = searchDynamicInfo;
        this.produceInfoList = arrayList5;
    }
}

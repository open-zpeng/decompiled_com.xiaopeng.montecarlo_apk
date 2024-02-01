package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CarWashInfo {
    private static final L.Tag TAG = new L.Tag("CarWashInfo");
    private String adcode;
    private String address;
    private String bizTime;
    private String brand;
    private String city;
    private String coordType;
    private int deviceCount;
    private double distance;
    private Long id;
    private String intro;
    private double latitude;
    private double longitude;
    private double navLatitude;
    private double navLongitude;
    private String phone;
    private String price;
    private String province;
    private String stationId;
    private String stationName;
    private String subCity;

    public CarWashInfo(Long l, String str, double d, double d2, double d3, double d4, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, String str11, String str12, String str13) {
        this.id = l;
        this.stationId = str;
        this.latitude = d;
        this.longitude = d2;
        this.navLatitude = d3;
        this.navLongitude = d4;
        this.coordType = str2;
        this.adcode = str3;
        this.stationName = str4;
        this.brand = str5;
        this.address = str6;
        this.province = str7;
        this.city = str8;
        this.subCity = str9;
        this.bizTime = str10;
        this.deviceCount = i;
        this.phone = str11;
        this.price = str12;
        this.intro = str13;
    }

    public CarWashInfo() {
    }

    public static XPPoiInfo toXPPoiInfo(CarWashInfo carWashInfo) {
        if (carWashInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setNaviLat(carWashInfo.getNavLatitude());
        xPPoiInfo.setNaviLon(carWashInfo.getNavLongitude());
        xPPoiInfo.setDisplayLat(carWashInfo.getLatitude());
        xPPoiInfo.setDisplayLon(carWashInfo.getLongitude());
        xPPoiInfo.setDistance(carWashInfo.getDistance());
        xPPoiInfo.setPoiId(carWashInfo.getStationId());
        xPPoiInfo.setName(carWashInfo.getStationName());
        xPPoiInfo.setAddress(carWashInfo.getAddress());
        xPPoiInfo.setTag(carWashInfo.getBrand());
        xPPoiInfo.setOpenTime(carWashInfo.getBizTime());
        xPPoiInfo.setTel(carWashInfo.getPhone());
        xPPoiInfo.setProvinceName(carWashInfo.getProvince());
        xPPoiInfo.setCityName(carWashInfo.getCity());
        xPPoiInfo.setDistrictName(carWashInfo.getSubCity());
        xPPoiInfo.setCategory(111);
        xPPoiInfo.setPoiSource(7);
        if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
            xPPoiInfo.setOffline(false);
        } else {
            xPPoiInfo.setOffline(true);
        }
        return xPPoiInfo;
    }

    public static ArrayList<XPPoiInfo> toXPPoiInfo(List<CarWashInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList<XPPoiInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(toXPPoiInfo(list.get(i)));
        }
        return arrayList;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getStationId() {
        return this.stationId;
    }

    public void setStationId(String str) {
        this.stationId = str;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public double getNavLatitude() {
        return this.navLatitude;
    }

    public void setNavLatitude(double d) {
        this.navLatitude = d;
    }

    public double getNavLongitude() {
        return this.navLongitude;
    }

    public void setNavLongitude(double d) {
        this.navLongitude = d;
    }

    public String getCoordType() {
        return this.coordType;
    }

    public void setCoordType(String str) {
        this.coordType = str;
    }

    public String getAdcode() {
        return this.adcode;
    }

    public void setAdcode(String str) {
        this.adcode = str;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStationName(String str) {
        this.stationName = str;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getSubCity() {
        return this.subCity;
    }

    public void setSubCity(String str) {
        this.subCity = str;
    }

    public String getBizTime() {
        return this.bizTime;
    }

    public void setBizTime(String str) {
        this.bizTime = str;
    }

    public int getDeviceCount() {
        return this.deviceCount;
    }

    public void setDeviceCount(int i) {
        this.deviceCount = i;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double d) {
        this.distance = d;
    }
}

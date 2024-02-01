package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
/* loaded from: classes3.dex */
public class HomeOrCompanyInfo {
    @SerializedName("address")
    String mAddress;
    @SerializedName("geoHash")
    String mGeoHash;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    String mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LNG)
    String mLng;
    @SerializedName("name")
    String mName;
    @SerializedName("poiId")
    String mPoiId;

    protected boolean canEqual(Object obj) {
        return obj instanceof HomeOrCompanyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HomeOrCompanyInfo) {
            HomeOrCompanyInfo homeOrCompanyInfo = (HomeOrCompanyInfo) obj;
            if (homeOrCompanyInfo.canEqual(this)) {
                String address = getAddress();
                String address2 = homeOrCompanyInfo.getAddress();
                if (address != null ? address.equals(address2) : address2 == null) {
                    String poiId = getPoiId();
                    String poiId2 = homeOrCompanyInfo.getPoiId();
                    if (poiId != null ? poiId.equals(poiId2) : poiId2 == null) {
                        String name = getName();
                        String name2 = homeOrCompanyInfo.getName();
                        if (name != null ? name.equals(name2) : name2 == null) {
                            String lng = getLng();
                            String lng2 = homeOrCompanyInfo.getLng();
                            if (lng != null ? lng.equals(lng2) : lng2 == null) {
                                String lat = getLat();
                                String lat2 = homeOrCompanyInfo.getLat();
                                if (lat != null ? lat.equals(lat2) : lat2 == null) {
                                    String geoHash = getGeoHash();
                                    String geoHash2 = homeOrCompanyInfo.getGeoHash();
                                    return geoHash != null ? geoHash.equals(geoHash2) : geoHash2 == null;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String address = getAddress();
        int hashCode = address == null ? 43 : address.hashCode();
        String poiId = getPoiId();
        int hashCode2 = ((hashCode + 59) * 59) + (poiId == null ? 43 : poiId.hashCode());
        String name = getName();
        int hashCode3 = (hashCode2 * 59) + (name == null ? 43 : name.hashCode());
        String lng = getLng();
        int hashCode4 = (hashCode3 * 59) + (lng == null ? 43 : lng.hashCode());
        String lat = getLat();
        int hashCode5 = (hashCode4 * 59) + (lat == null ? 43 : lat.hashCode());
        String geoHash = getGeoHash();
        return (hashCode5 * 59) + (geoHash != null ? geoHash.hashCode() : 43);
    }

    public HomeOrCompanyInfo setAddress(String str) {
        this.mAddress = str;
        return this;
    }

    public HomeOrCompanyInfo setGeoHash(String str) {
        this.mGeoHash = str;
        return this;
    }

    public HomeOrCompanyInfo setLat(String str) {
        this.mLat = str;
        return this;
    }

    public HomeOrCompanyInfo setLng(String str) {
        this.mLng = str;
        return this;
    }

    public HomeOrCompanyInfo setName(String str) {
        this.mName = str;
        return this;
    }

    public HomeOrCompanyInfo setPoiId(String str) {
        this.mPoiId = str;
        return this;
    }

    public String toString() {
        return "HomeOrCompanyInfo(mAddress=" + getAddress() + ", mPoiId=" + getPoiId() + ", mName=" + getName() + ", mLng=" + getLng() + ", mLat=" + getLat() + ", mGeoHash=" + getGeoHash() + ")";
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public String getName() {
        return this.mName;
    }

    public String getLng() {
        return this.mLng;
    }

    public String getLat() {
        return this.mLat;
    }

    public String getGeoHash() {
        return this.mGeoHash;
    }
}

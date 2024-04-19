package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
/* loaded from: classes2.dex */
public class NaviLocationInfo {
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    private Double mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LON)
    private Double mLon;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviLocationInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviLocationInfo) {
            NaviLocationInfo naviLocationInfo = (NaviLocationInfo) obj;
            if (naviLocationInfo.canEqual(this)) {
                Double lat = getLat();
                Double lat2 = naviLocationInfo.getLat();
                if (lat != null ? lat.equals(lat2) : lat2 == null) {
                    Double lon = getLon();
                    Double lon2 = naviLocationInfo.getLon();
                    return lon != null ? lon.equals(lon2) : lon2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Double lat = getLat();
        int hashCode = lat == null ? 43 : lat.hashCode();
        Double lon = getLon();
        return ((hashCode + 59) * 59) + (lon != null ? lon.hashCode() : 43);
    }

    public NaviLocationInfo setLat(Double d) {
        this.mLat = d;
        return this;
    }

    public NaviLocationInfo setLon(Double d) {
        this.mLon = d;
        return this;
    }

    public String toString() {
        return "NaviLocationInfo(mLat=" + getLat() + ", mLon=" + getLon() + ")";
    }

    public Double getLat() {
        return this.mLat;
    }

    public Double getLon() {
        return this.mLon;
    }
}

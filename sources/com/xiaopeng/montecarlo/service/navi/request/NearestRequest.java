package com.xiaopeng.montecarlo.service.navi.request;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
/* loaded from: classes3.dex */
public class NearestRequest {
    public static final String TYPE_GCJ02 = "gcj02";
    public static final String TYPE_WGS84 = "wgs84";
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    private double mLatitude;
    @SerializedName(CPSearchParam.PARAM_KEY_LON)
    private double mLongitude;
    @SerializedName("type")
    private String mType;

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public String toString() {
        return "NearestRequest{mType='" + this.mType + "', mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + '}';
    }
}

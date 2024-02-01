package com.xiaopeng.montecarlo.navcore.speech.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class SpeechDataCenterPoi implements Serializable {
    @SerializedName("latitude")
    private double mLatitude;
    @SerializedName("longitude")
    private double mLongitude;
    @SerializedName("name")
    private String mName;

    public Double getLatitude() {
        return Double.valueOf(this.mLatitude);
    }

    public void setLatitude(Double d) {
        this.mLatitude = d.doubleValue();
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public XPPoiInfo toXPPoiInfo() {
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setName(this.mName);
        xPPoiInfo.setDisplayLon(this.mLongitude);
        xPPoiInfo.setDisplayLat(this.mLatitude);
        return xPPoiInfo;
    }

    public String toString() {
        return "SpeechDataCenterPoi{mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + ", mName='" + this.mName + "'}";
    }
}

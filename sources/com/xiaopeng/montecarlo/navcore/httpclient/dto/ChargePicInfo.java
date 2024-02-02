package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class ChargePicInfo {
    @SerializedName("stationImgUrl")
    @Deprecated
    public String mStationImgUrl;

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargePicInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargePicInfo) {
            ChargePicInfo chargePicInfo = (ChargePicInfo) obj;
            if (chargePicInfo.canEqual(this)) {
                String stationImgUrl = getStationImgUrl();
                String stationImgUrl2 = chargePicInfo.getStationImgUrl();
                return stationImgUrl != null ? stationImgUrl.equals(stationImgUrl2) : stationImgUrl2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String stationImgUrl = getStationImgUrl();
        return 59 + (stationImgUrl == null ? 43 : stationImgUrl.hashCode());
    }

    @Deprecated
    public ChargePicInfo setStationImgUrl(String str) {
        this.mStationImgUrl = str;
        return this;
    }

    public String toString() {
        return "ChargePicInfo(mStationImgUrl=" + getStationImgUrl() + ")";
    }

    @Deprecated
    public String getStationImgUrl() {
        return this.mStationImgUrl;
    }
}

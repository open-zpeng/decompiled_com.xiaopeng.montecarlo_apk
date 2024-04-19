package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.XPNaviServerPoiInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviParkRecommendResponse {
    @SerializedName("parks")
    private List<XPNaviServerPoiInfo> mParks;
    @SerializedName("result_status")
    private String mResultStatus;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviParkRecommendResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviParkRecommendResponse) {
            NaviParkRecommendResponse naviParkRecommendResponse = (NaviParkRecommendResponse) obj;
            if (naviParkRecommendResponse.canEqual(this)) {
                String resultStatus = getResultStatus();
                String resultStatus2 = naviParkRecommendResponse.getResultStatus();
                if (resultStatus != null ? resultStatus.equals(resultStatus2) : resultStatus2 == null) {
                    List<XPNaviServerPoiInfo> parks = getParks();
                    List<XPNaviServerPoiInfo> parks2 = naviParkRecommendResponse.getParks();
                    return parks != null ? parks.equals(parks2) : parks2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String resultStatus = getResultStatus();
        int hashCode = resultStatus == null ? 43 : resultStatus.hashCode();
        List<XPNaviServerPoiInfo> parks = getParks();
        return ((hashCode + 59) * 59) + (parks != null ? parks.hashCode() : 43);
    }

    public NaviParkRecommendResponse setParks(List<XPNaviServerPoiInfo> list) {
        this.mParks = list;
        return this;
    }

    public NaviParkRecommendResponse setResultStatus(String str) {
        this.mResultStatus = str;
        return this;
    }

    public String toString() {
        return "NaviParkRecommendResponse(mResultStatus=" + getResultStatus() + ", mParks=" + getParks() + ")";
    }

    public String getResultStatus() {
        return this.mResultStatus;
    }

    public List<XPNaviServerPoiInfo> getParks() {
        return this.mParks;
    }
}

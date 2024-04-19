package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviStationInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviSearchResponse {
    @SerializedName(CPSearchParam.PARAM_KEY_STATIONS)
    private List<NaviStationInfo> mStations;
    @SerializedName("total")
    private Integer mTotal;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviSearchResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviSearchResponse) {
            NaviSearchResponse naviSearchResponse = (NaviSearchResponse) obj;
            if (naviSearchResponse.canEqual(this)) {
                Integer total = getTotal();
                Integer total2 = naviSearchResponse.getTotal();
                if (total != null ? total.equals(total2) : total2 == null) {
                    List<NaviStationInfo> stations = getStations();
                    List<NaviStationInfo> stations2 = naviSearchResponse.getStations();
                    return stations != null ? stations.equals(stations2) : stations2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Integer total = getTotal();
        int hashCode = total == null ? 43 : total.hashCode();
        List<NaviStationInfo> stations = getStations();
        return ((hashCode + 59) * 59) + (stations != null ? stations.hashCode() : 43);
    }

    public NaviSearchResponse setStations(List<NaviStationInfo> list) {
        this.mStations = list;
        return this;
    }

    public NaviSearchResponse setTotal(Integer num) {
        this.mTotal = num;
        return this;
    }

    public String toString() {
        return "NaviSearchResponse(mTotal=" + getTotal() + ", mStations=" + getStations() + ")";
    }

    public Integer getTotal() {
        return this.mTotal;
    }

    public List<NaviStationInfo> getStations() {
        return this.mStations;
    }
}

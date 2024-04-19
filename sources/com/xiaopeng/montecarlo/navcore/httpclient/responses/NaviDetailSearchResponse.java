package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviPoiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviDetailSearchResponse {
    @SerializedName("total")
    private Integer mTotal = 0;
    @SerializedName("data")
    private List<NaviPoiInfo> mData = new ArrayList();

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviDetailSearchResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviDetailSearchResponse) {
            NaviDetailSearchResponse naviDetailSearchResponse = (NaviDetailSearchResponse) obj;
            if (naviDetailSearchResponse.canEqual(this)) {
                Integer total = getTotal();
                Integer total2 = naviDetailSearchResponse.getTotal();
                if (total != null ? total.equals(total2) : total2 == null) {
                    List<NaviPoiInfo> data = getData();
                    List<NaviPoiInfo> data2 = naviDetailSearchResponse.getData();
                    return data != null ? data.equals(data2) : data2 == null;
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
        List<NaviPoiInfo> data = getData();
        return ((hashCode + 59) * 59) + (data != null ? data.hashCode() : 43);
    }

    public NaviDetailSearchResponse setData(List<NaviPoiInfo> list) {
        this.mData = list;
        return this;
    }

    public NaviDetailSearchResponse setTotal(Integer num) {
        this.mTotal = num;
        return this;
    }

    public String toString() {
        return "NaviDetailSearchResponse(mTotal=" + getTotal() + ", mData=" + getData() + ")";
    }

    public Integer getTotal() {
        return this.mTotal;
    }

    public List<NaviPoiInfo> getData() {
        return this.mData;
    }
}

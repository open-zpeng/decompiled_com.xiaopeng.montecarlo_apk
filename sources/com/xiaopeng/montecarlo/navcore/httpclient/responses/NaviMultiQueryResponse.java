package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviMultiQueryResponse {
    @SerializedName("result_list")
    private List<NaviQueryResponse> mResultList;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviMultiQueryResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviMultiQueryResponse) {
            NaviMultiQueryResponse naviMultiQueryResponse = (NaviMultiQueryResponse) obj;
            if (naviMultiQueryResponse.canEqual(this)) {
                List<NaviQueryResponse> resultList = getResultList();
                List<NaviQueryResponse> resultList2 = naviMultiQueryResponse.getResultList();
                return resultList != null ? resultList.equals(resultList2) : resultList2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        List<NaviQueryResponse> resultList = getResultList();
        return 59 + (resultList == null ? 43 : resultList.hashCode());
    }

    public NaviMultiQueryResponse setResultList(List<NaviQueryResponse> list) {
        this.mResultList = list;
        return this;
    }

    public String toString() {
        return "NaviMultiQueryResponse(mResultList=" + getResultList() + ")";
    }

    public List<NaviQueryResponse> getResultList() {
        return this.mResultList;
    }
}
